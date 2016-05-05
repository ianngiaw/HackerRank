import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  private static StringBuilder inorderString(int[][] tree, int root) {
    if (root > 0 && root < tree.length) {
      StringBuilder sb = inorderString(tree, tree[root][0]);
      sb.append(root + " ");
      sb.append(inorderString(tree, tree[root][1]));
      return sb;
    }
    return new StringBuilder();
  }

  private static void swapSubtrees(int[][] tree, int root, int depth, int K) {
    if (root <= 0 || root >= tree.length) return;
    if (depth % K == 0) {
      int a = tree[root][0];
      tree[root][0] = tree[root][1];
      tree[root][1] = a;
    }
    swapSubtrees(tree, tree[root][0], depth + 1, K);
    swapSubtrees(tree, tree[root][1], depth + 1, K);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] tree = new int[N + 1][2];

    for (int i = 1; i <= N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      tree[i][0] = a;
      tree[i][1] = b;
    }

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int K = sc.nextInt();

      swapSubtrees(tree, 1, 1, K);

      StringBuilder sb = inorderString(tree, 1);
      System.out.println(sb.toString().trim());
    }
  }
}
