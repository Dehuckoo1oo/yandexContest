package sprint02.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        List<StringBuilder> newRows = new ArrayList<>();
        for (int newRowNum = 0; newRowNum < n; newRowNum++) {
            newRows.add(new StringBuilder());
        }
        for (int rowNum = 0; rowNum < m; rowNum++) {
            StringTokenizer row = new StringTokenizer(reader.readLine());
            for (int columnNum = 0; columnNum < n; columnNum++) {
                newRows.get(columnNum).append(row.nextToken()).append(" ");
            }
        }
        for (int row = 0; row < n; row ++) {
            System.out.println(newRows.get(row));
        }
    }
}
