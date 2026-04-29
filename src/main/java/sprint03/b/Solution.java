package sprint03.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Solution {
    public static Map<Character, String> numberToChars = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequence = reader.readLine();
        StringBuilder answer = new StringBuilder();
        generateCombinations(new StringBuilder(), sequence, 0, answer);
        System.out.println(answer.deleteCharAt(answer.length() - 1));
    }

    public static void generateCombinations(StringBuilder prefix, String sequence, int curPosition, StringBuilder answer) {
        if (curPosition == sequence.length()) {
            answer.append(prefix).append(" ");
            return;
        }
        char curNum = sequence.charAt(curPosition);
        String letters = numberToChars.get(curNum);
        for (int i = 0; i < letters.length(); i++) {
            prefix.append(letters.charAt(i));
            generateCombinations(prefix, sequence, curPosition + 1, answer);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
