package yandex.sprint04.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SolutionGood {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int right = 0;
        int answer = 0;
        while (right < str.length()) {
            char curChar = str.charAt(right);
            char lastChar = str.charAt(left);
            if (chars.contains(curChar)) {
                chars.remove(lastChar);
                left++;
            } else {
                chars.add(curChar);
                answer = Math.max(answer, right - left + 1);
                right++;
            }
        }
    }
}

