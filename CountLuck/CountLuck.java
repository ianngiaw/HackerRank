import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	private static char EMPTY = '.';
	private static char TREE = 'X';
	private static char START = 'M';
	private static char PORTKEY = '*';
	private static char VISITED = 'V';

	private static String PASSED = "Impressed";
	private static String FAILED = "Oops!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	sc.nextLine();

        	char[][] forest = new char[n][m];
        	Coordinate start = new Coordinate();
        	for (int j = 0; j < n; j++) {
        		String line = sc.nextLine().trim();
        		char[] charArr = line.toCharArray();
        		for (int k = 0; k < m; k++) {
        			forest[j][k] = charArr[k];
        			if (charArr[k] == START) {
        				start.row = j;
        				start.col = k;
        			}
        		}
        	}
        	int k = sc.nextInt();
        	System.out.println(search(start, forest, k) ? PASSED : FAILED);
        }
    }

    private static boolean search(Coordinate point, char[][] forest, int k) {
    	if (k == 0 && forest[point.row][point.col] == PORTKEY) return true;
    	if (k < 0) return false;

    	char originalVal = forest[point.row][point.col];
    	forest[point.row][point.col] = VISITED;

    	ArrayList<Coordinate> adj = findEmptyCoordinates(point, forest);
    	k -= adj.size() > 1 ? 1 : 0;
    	for (Coordinate c : adj) {
    		if (search(c, forest, k)) return true;
    	}

    	forest[point.row][point.col] = originalVal;
    	return false;
    }

    private static ArrayList<Coordinate> findEmptyCoordinates(Coordinate point, char[][] forest) {
    	ArrayList<Coordinate> res = new ArrayList<Coordinate>();
    	Coordinate up = point.up();
    	Coordinate down = point.down();
    	Coordinate left = point.left();
    	Coordinate right = point.right();

    	if (up.isValid(forest)) res.add(up);
    	if (down.isValid(forest)) res.add(down);
    	if (left.isValid(forest)) res.add(left);
    	if (right.isValid(forest)) res.add(right);

    	return res;
    }

    private static class Coordinate {
    	int row;
    	int col;

    	public Coordinate up() {
    		Coordinate up = new Coordinate();
    		up.row = row - 1;
    		up.col = col;
    		return up;
    	}

    	public Coordinate down() {
    		Coordinate down = new Coordinate();
    		down.row = row + 1;
    		down.col = col;
    		return down;
    	}

    	public Coordinate left() {
    		Coordinate left = new Coordinate();
    		left.row = row;
    		left.col = col - 1;
    		return left;
    	}

    	public Coordinate right() {
    		Coordinate right = new Coordinate();
    		right.row = row;
    		right.col = col + 1;
    		return right;
    	}

    	public boolean isValid(char[][] charArr) {
    		int height = charArr.length;
    		int width = charArr[0].length;
    		boolean isRowValid = row < height && row >= 0;
    		boolean isColValid = col < width && col >= 0;
    		if (isRowValid && isColValid) {
    			return charArr[row][col] == EMPTY || charArr[row][col] == PORTKEY;
    		}
    		return false;
    	}
    }
}