import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstString = sc.next();
        String secondString = sc.next();

        HashMap<Character, Integer> firstMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondMap = new HashMap<Character, Integer>();

        populateMap(firstString, firstMap);
        populateMap(secondString, secondMap);

        System.out.print(countMapDiff(firstMap, secondMap));
    }

    static void populateMap(String str, HashMap<Character, Integer> map) {
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            int count = map.get(c);
            map.put(c, count + 1);
        }
    }

    static int countMapDiff(HashMap<Character, Integer> firstMap, HashMap<Character, Integer> secondMap) {
        int count = 0;
        HashMap<Character, Integer> tempFirstMap = new HashMap<Character, Integer>();
        for (char c : firstMap.keySet()) {
            int firstCharCount = firstMap.get(c);
            if (secondMap.containsKey(c)) {
                int secondCharCount = secondMap.get(c);
                if (firstCharCount > secondCharCount) {
                    tempFirstMap.put(c, secondCharCount);
                    count += firstCharCount - secondCharCount;
                } else {
                    tempFirstMap.put(c, firstCharCount);
                }
            } else {
                count += firstCharCount;
            }
        }
        firstMap = tempFirstMap;
        for (char c : secondMap.keySet()) {
            int secondCharCount = secondMap.get(c);
            if (firstMap.containsKey(c)) {
                int firstCharCount = firstMap.get(c);
                if (secondCharCount > firstCharCount) {
                    count += secondCharCount - firstCharCount;
                }
            } else {
                count += secondCharCount;
            }
        }
        return count;
    }
}