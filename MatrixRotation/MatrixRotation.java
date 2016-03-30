import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt(), R = sc.nextInt();
        int[][] mat = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(M, N) / 2;
        for (int i = 0; i < layers; i++) {
            rotateLayer(mat, i, R);
        }
        printMatrix(mat);
    }

    static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mat[i].length; j++) {
                sb.append(mat[i][j]);
                sb.append(' ');
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void rotateLayer(int[][] matrix, int layer, int rotations) {
        int height = matrix.length - layer * 2;
        int width = matrix[0].length - layer * 2;
        int total = 2 * width + 2 * height - 4;
        int offset = rotations % total;
        if (offset == 0) return;

        int[] elements = new int[total];
        for (int i = 0; i < total; i++) {
            int[] position = indexToPosition(layer, height, width, total, i);
            elements[i] = matrix[position[0]][position[1]];
        }
        for (int i = 0; i < total; i++) {
            int newIndex = (i + offset) % total;
            int[] newPos = indexToPosition(layer, height, width, total, newIndex);
            matrix[newPos[0]][newPos[1]] = elements[i];
        }
    }

    static int[] indexToPosition(int layer, int height, int width, int total, int index) {
        int[] position = {0, 0};
        boolean reflect = index / (total / 2) == 1;
        index = index % (total / 2);
        if (index < height) {
            position[0] = index;
        } else {
            position[0] = height - 1;
            position[1] = index - (height - 1);
        }
        if (reflect) {
            position[0] = height - 1 - position[0];
            position[1] = width - 1 - position[1];
        }
        position[0] += layer;
        position[1] += layer;
        return position; 
    }
}