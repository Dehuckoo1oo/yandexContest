package sprint04.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String[] strings = new String[n];
        String[] sortedString = new String[n];
        for(int i = 0; i < n; i++) {
            int[] countSymbols = new int[200];
            String curStr = tokenizer.nextToken();
            strings[i] = curStr;
            for (int j = 0; j < curStr.length(); j++) {
                countSymbols[curStr.charAt(j) - 'A']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 200; j++) {
                int curCharCount = countSymbols[j];
                for(int k = 0; k < curCharCount; k++) {
                    sb.append((char)('A' + j));
                }
            }
            sortedString[i] = sb.toString();
        }
        Map<String, List<Integer>> mapStringToIdx = new HashMap<>();
        for(int idx = 0; idx < sortedString.length; idx ++){
            mapStringToIdx.computeIfAbsent(sortedString[idx], v -> new ArrayList<>()).add(idx);
        }
        List<List<Integer>> groupedIdxs = new ArrayList<>(mapStringToIdx.values());
        groupedIdxs.sort(Comparator.comparingInt(v -> v.get(0)));
        StringBuilder sb = new StringBuilder();
        for (List<Integer> curList : groupedIdxs) {
            for(int curIdx : curList) {
                sb.append(curIdx).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }
}
