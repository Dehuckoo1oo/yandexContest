package yandex.sprint07_hungry_N_dynamic.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        long mod = 1_000_000_007L;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long sum = 0;
            int j = Math.max(1, i - k);
            while (j < i) {
                dp[i] = dp[i] + dp[j] % mod;
                j++;
            }
        }
        System.out.println(dp[n]);
    }
}
