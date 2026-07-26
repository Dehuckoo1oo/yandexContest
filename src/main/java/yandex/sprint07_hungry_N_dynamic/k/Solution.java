package yandex.sprint07_hungry_N_dynamic.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] first = readArray(reader, n);
        int m = Integer.parseInt(reader.readLine());
        int[] second = readArray(reader, m);
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }
        int lcsLength = dp[n][m];
        System.out.println(lcsLength);
        if (lcsLength == 0) {
            return;
        }
        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> secondIndexes = new ArrayList<>();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (first[i - 1] == second[j - 1]) {
                firstIndexes.add(i);
                secondIndexes.add(j);
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        Collections.reverse(firstIndexes);
        Collections.reverse(secondIndexes);
        StringBuilder firstLine = new StringBuilder();
        for (int index : firstIndexes) {
            firstLine.append(index).append(' ');
        }
        StringBuilder secondLine = new StringBuilder();
        for (int index : secondIndexes) {
            secondLine.append(index).append(' ');
        }
        System.out.println(firstLine);
        System.out.println(secondLine);
    }

    private static int[] readArray(BufferedReader reader, int length) throws IOException {
        int[] array = new int[length];
        if (length == 0) {
            return array;
        }
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return array;
    }
}