package yandex.sprint07_hungry_N_dynamic.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[n + 1][m + 1];
        int[][] dp = new int[n + 2][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] row = reader.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if (row[j - 1] == '1') {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (matrix[i][j] == 1) {
                    dp[i][j] += 1;
                }
                skipConsole();
                printMatrix(matrix);
                System.out.println("===============");
                printMatrix(dp);
            }
        }
        System.out.println(dp[1][m]);
    }

    public static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void skipConsole() {
        for (int g = 0; g < 100; g++) {
            System.out.println();
        }
    }
}
