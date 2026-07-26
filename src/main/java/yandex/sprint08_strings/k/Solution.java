package yandex.sprint08_strings.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String filteredA = filter(a);
        String filteredB = filter(b);
        int result = filteredA.compareTo(filteredB);
        if (result < 0) {
            System.out.println(-1);
        } else if (result > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static String filter(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c % 2 == 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
