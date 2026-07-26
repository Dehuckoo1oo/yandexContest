package yandex.sprint07_hungry_N_dynamic.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int capacity = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        boolean[] dp = new boolean[capacity + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(tokenizer.nextToken());

            for (int currentWeight = capacity; currentWeight >= weight; currentWeight--) {
                if (dp[currentWeight - weight]) {
                    dp[currentWeight] = true;
                }
            }
        }

        for (int weight = capacity; weight >= 0; weight--) {
            if (dp[weight]) {
                System.out.println(weight);
                return;
            }
        }
    }
}