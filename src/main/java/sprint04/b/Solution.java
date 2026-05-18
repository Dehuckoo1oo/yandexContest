package sprint04.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int roundCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Map<Integer, Integer> mapSumToIndex = new HashMap<>();
        mapSumToIndex.put(0, 0);
        int maxSize = 0;
        int totalSum = 0;
        for (int i = 1; i <= roundCount; i++) {
            int curResult = Integer.parseInt(tokenizer.nextToken());
            if (curResult == 1) {
                totalSum++;
            } else {
                totalSum--;
            }
            if (mapSumToIndex.containsKey(totalSum)) {
                maxSize = Math.max(maxSize, i - mapSumToIndex.get(totalSum));
            } else {
                mapSumToIndex.put(totalSum, i);
            }
        }
        System.out.println(maxSize);
    }
}
