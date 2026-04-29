package sprint03.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String subString = reader.readLine();
        String string = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < subString.length()) {
            char curChar = subString.charAt(i);
            while (j < string.length()) {
                if (curChar == string.charAt(j)) {
                    sb.append(curChar);
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }
        if (subString.equals(sb.toString())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
