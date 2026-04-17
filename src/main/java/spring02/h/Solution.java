package spring02.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        is_correct_bracket_seq();
    }

    public static void is_correct_bracket_seq() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bracketString = reader.readLine();
        int size = bracketString.length();
        if (size % 2 == 1) {
            System.out.println("False");
            return;
        }
        List<Character> existsOpenBrackets = List.of('{', '[', '(');
        List<Character> existsCloseBrackets = List.of('}', ']', ')');
        Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < size; i++) {
            char symbol = bracketString.charAt(i);
            int indexOfOpenBracket = existsOpenBrackets.indexOf(symbol);
            int indexOfCloseBracket = existsCloseBrackets.indexOf(symbol);
            if (indexOfOpenBracket != -1) {
                openBrackets.add(symbol);
            } else {
                if (openBrackets.isEmpty()) {
                    System.out.println("False");
                    return;
                }
                char expectedBracket = existsOpenBrackets.get(indexOfCloseBracket);
                char curBracket = openBrackets.peek();
                if(expectedBracket != curBracket) {
                    System.out.println("False");
                    return;
                }
                openBrackets.pop();
            }
        }
        if (openBrackets.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
