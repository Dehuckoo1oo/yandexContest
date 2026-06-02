package yandex.sprint04.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }
        Map<Character, Character> mapChar1ToChar2 = new HashMap<>();
        Map<Character, Character> mapChar2ToChar1 = new HashMap<>();
        mapChar1ToChar2.put(str1.charAt(0), str2.charAt(0));
        for (int i = 1; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            Character foundChar2 = mapChar1ToChar2.get(char1);
            Character foundChar1 = mapChar2ToChar1.get(char2);
            if (foundChar2 == null) {
                mapChar1ToChar2.put(char1, char2);
            } else {
                if (foundChar2 != char2) {
                    System.out.println("NO");
                    return;
                }
            }
            if (foundChar1 == null) {
                mapChar2ToChar1.put(char2, char1);
            } else {
                if(foundChar1 != char1) {
                    System.out.println("NO");
                    return;
                }
            }

        }
        System.out.println("YES");
    }
}
