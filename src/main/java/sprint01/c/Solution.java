package sprint01.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //прочитаем диапазоны и создадим матрицу
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][m];
        //заполним матрицу
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        //заполним координаты
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        //решение
        if (b < m - 1) {
            result.add(matrix[a][b + 1]);
        }
        if (a > 0) {
            result.add(matrix[a - 1][b]);
        }
        if (b > 0) {
            result.add(matrix[a][b - 1]);
        }
        if (a < n - 1) {
            result.add(matrix[a + 1][b]);
        }
        result.sort(Comparator.naturalOrder());
        result.forEach(v -> {
            sb.append(v).append(" ");
        });
        System.out.println(sb);
    }
}