package yandex.sprint08_strings.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int m = Integer.parseInt(reader.readLine());
        int[] pattern = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            pattern[i] = Integer.parseInt(tokenizer.nextToken());
        }
        List<Integer> occurrences = new ArrayList<>();
        int start = 0;
        while (true) {
            int pos = find(arr, pattern, start);
            if (pos == -1) {
                break;
            }
            occurrences.add(pos);
            start = pos + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer elem : occurrences) {
            sb.append(elem + 1).append(" ");
        }
        System.out.println(sb);
    }

    private static int find(int[] arr, int[] pattern, int start) {
        if (arr.length < pattern.length) {
            return -1;
        }
        for (int pos = start; pos <= arr.length - pattern.length; pos++) {
            boolean match = true;
            Integer etalonDelta = null;
            for (int offset = 0; offset < pattern.length; offset++) {
                if (etalonDelta == null) {
                    etalonDelta = arr[pos + offset] - pattern[offset];
                }
                if (arr[pos + offset] - pattern[offset] != etalonDelta) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return pos;
            }
        }
        return -1;
    }
}
