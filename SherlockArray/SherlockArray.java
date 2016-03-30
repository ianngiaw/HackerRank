import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static boolean findCenter(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if (arr[i-1] == arr[arr.length - 1] - arr[i]) return true;
			if (arr[i-1] > arr[arr.length - 1] - arr[i]) return false;
		}
		return false;
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();

    	while (T > 0) {
    		int N = sc.nextInt();
    		int[] arr = new int[N+1];
    		arr[0] = 0;
    		for(int i = 1; i <= N; i++) {
    			arr[i] = arr[i-1] + sc.nextInt();
    		}
    		System.out.println(findCenter(arr) ? "YES": "NO");
    		T--;
    	}
    }
}