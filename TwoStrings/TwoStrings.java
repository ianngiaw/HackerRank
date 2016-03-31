import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
        	String strA = sc.next().trim();
        	HashSet<Character> hs = new HashSet<Character>();
        	for (char c : strA.toCharArray()) {
        		hs.add(c);
        	}
        	String strB = sc.next().trim();
        	boolean found = false;
        	for (char c : strB.toCharArray()) {
        		if (hs.contains(c)) {
        			found = true;
        			break;
        		}
        	}
        	System.out.println(found ? "YES" : "NO");
        }
    }
}