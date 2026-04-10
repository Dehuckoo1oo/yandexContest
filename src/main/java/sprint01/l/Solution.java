package sprint01.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        Map<Character, Integer> uniqueChars = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (uniqueChars.containsKey(str1.charAt(i))) {
                Integer value = uniqueChars.get(str1.charAt(i)) + 1;
                uniqueChars.put(str1.charAt(i), value);
            } else {
                uniqueChars.put(str1.charAt(i), 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!uniqueChars.containsKey(str2.charAt(i))) {
                System.out.println(str2.charAt(i));
                return;
            }
            int value = uniqueChars.get(str2.charAt(i));
            if (value > 0) {
                uniqueChars.put(str2.charAt(i),value - 1);
            } else {
                System.out.println(str2.charAt(i));
                return;
            }
        }
    }
}