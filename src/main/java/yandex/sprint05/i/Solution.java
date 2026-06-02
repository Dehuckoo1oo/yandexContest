package yandex.sprint05.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(count(n));
    }

    public static int count(int n) {
        if (n < 2) {
            return 1;
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            result = result + count(left) * count(right);
        }
        return result;
    }
}