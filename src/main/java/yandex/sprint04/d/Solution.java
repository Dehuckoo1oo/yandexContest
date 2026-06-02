package yandex.sprint04.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(reader.readLine());
        long m = Long.parseLong(reader.readLine());
        String s = reader.readLine();
        long hash = 0;
        for(int i = 0; i < s.length(); i++) {
            hash = (hash * a + s.charAt(i)) % m;
        }
        System.out.println(hash);
    }
}
