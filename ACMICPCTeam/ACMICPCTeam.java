import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        int maxCount = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int covered = compareTopics(topic[i].toCharArray(), topic[j].toCharArray());
                if (covered == max) {
                    maxCount++;
                } else if (covered > max) {
                    max = covered;
                    maxCount = 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxCount);
    }

    static int compareTopics(char[] p1, char[] p2) {
        int count = 0;
        for (int i = 0; i < p1.length; i++) {
            if (p1[i] == '1' || p2[i] == '1') count++;
        }
        return count;
    }
    
}