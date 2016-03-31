import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
        	int A = sc.nextInt(), B = sc.nextInt();
    		double rtA = Math.sqrt(A);
    		double rtB = Math.sqrt(B);
    		int ceilRtA = (int) Math.ceil(rtA);
    		int floorRtB = (int) Math.floor(rtB);
    		System.out.println(floorRtB - ceilRtA + 1);
        }
    }
}