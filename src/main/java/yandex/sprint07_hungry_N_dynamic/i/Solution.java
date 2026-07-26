package yandex.sprint07_hungry_N_dynamic.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[n + 1][m + 1];
        int[][] dp = new int[n + 2][m + 2];
        List<Character> path = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            char[] row = reader.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if (row[j - 1] == '1') {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = n; i > 0; i--) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                dp[i][j] += matrix[i][j];
            }
        }
        int i = 1;
        int j = m;
        while (i != n || j != 1) {
            if (i == n) {
                j--;
                path.add('R');
            } else if (j == 1) {
                i++;
                path.add('U');
            } else if(dp[i + 1][j] > dp[i][j - 1]) {
                path.add('U');
                i++;
            } else {
                path.add('R');
                j--;
            }
        }
        List<Character> reversedPath = path.reversed();
        StringBuilder sb = new StringBuilder();
        for (char c : reversedPath) {
            sb.append(c);
        }
        System.out.println(dp[1][m]);
        System.out.println(sb);
    }
}
