package yandex.sprint06_graph.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int firstNode = Integer.parseInt(tokenizer.nextToken());
            int secondNode = Integer.parseInt(tokenizer.nextToken());
            adjMatrix[firstNode - 1][secondNode - 1] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }
}
