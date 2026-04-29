package sprint03.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int countOpenBrackets = 0;
        int countCloseBrackets = 0;
        generateBrackets(new StringBuilder(), n, countOpenBrackets, countCloseBrackets);
    }

    public static void generateBrackets(StringBuilder prefix, int n, int countOpenBrackets, int countCloseBrackets) {
        if (countOpenBrackets == n && countCloseBrackets == n) {
            System.out.println(prefix);
            return;
        }
        if(countOpenBrackets < n) {
            generateBrackets(prefix.append("("), n, countOpenBrackets + 1, countCloseBrackets);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        if(countCloseBrackets < countOpenBrackets) {
            generateBrackets(prefix.append(")"), n, countOpenBrackets, countCloseBrackets + 1);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
