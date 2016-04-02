import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Character> set = new HashSet<Character>();
        String first = sc.next().trim();
        for (char c : first.toCharArray()) {
            set.add(c);
        }
        for(int i = 1; i < n; i++) {
            HashSet<Character> tempSet = new HashSet<Character>();
            String rock = sc.next().trim();
            for (char c : rock.toCharArray()) {
                if (set.contains(c)) tempSet.add(c);
            }
            set = tempSet;
        }
        System.out.println(set.size());
    }
}