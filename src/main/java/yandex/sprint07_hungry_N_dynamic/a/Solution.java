package yandex.sprint07_hungry_N_dynamic.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 0) {
                profit = profit + arr[i] - arr[i - 1];
            }
        }
        System.out.println(profit);
    }
}
