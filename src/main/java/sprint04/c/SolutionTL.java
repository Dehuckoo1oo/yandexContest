package sprint04.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SolutionTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }
        Map<Character, StringBuilder> map1 = new HashMap<>();
        Map<Character, StringBuilder> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            map1.computeIfAbsent(char1, v -> new StringBuilder()).append(i);
            map2.computeIfAbsent(char2, v -> new StringBuilder()).append(i);
            String char1Is = map1.get(char1).toString();
            String char2Is = map2.get(char2).toString();
            if (!char1Is.equals(char2Is)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
