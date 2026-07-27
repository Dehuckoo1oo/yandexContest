package yandex.sprint08_strings.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        System.out.println(isValid(a, b) ? "OK" : "FAIL");
    }

    private static boolean isValid(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return isValid(str2, str1);
        }
        int failCount = 1;
        int sizeDelta = str1.length() - str2.length();
        if (sizeDelta > 1) {
            return false;
        }
        if (sizeDelta == 0) {
            int i = 0;
            while (i < str1.length()) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    failCount--;
                }
                if (failCount < 0) {
                    return false;
                }
                i++;
            }
        } else {
            int i = 0;
            int j = 0;
            boolean isSkipped = false;
            while (i < str1.length() && j < str2.length()) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if(isSkipped) {
                        return false;
                    }
                    isSkipped = true;
                    i++;
                }
            }
        }
        return true;
    }
}
