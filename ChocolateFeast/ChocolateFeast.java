import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int totalChoclates(int numChocolates, int m) {
		if (numChocolates < m) {
			return numChocolates;
		}
		return numChocolates - numChocolates % m + totalChoclates(numChocolates / m + numChocolates % m, m);
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();

            int initialChocolates = n / c;
            System.out.println(totalChoclates(initialChocolates, m));
        }
    }
}
