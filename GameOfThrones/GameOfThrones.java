import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : inputString.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        int oddCount = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) oddCount++;
            if (oddCount > 1) break;
        }
        
        System.out.println(oddCount <= 1 ? "YES" : "NO");
        myScan.close();
    }
}
