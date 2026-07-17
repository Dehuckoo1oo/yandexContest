package yandex.sprint06_graph.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        Map<Integer, List<Integer>> nodeEdges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int firstNode = Integer.parseInt(tokenizer.nextToken());
            int secondNode = Integer.parseInt(tokenizer.nextToken());
            nodeEdges.computeIfAbsent(firstNode, v -> new ArrayList<>()).add(secondNode);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            List<Integer> curSecondNodes = nodeEdges.get(i);
            if (curSecondNodes != null) {
                sb.append(curSecondNodes.size()).append(" ");
                for (int curNode : curSecondNodes) {
                    sb.append(curNode).append(" ");
                }
                sb.append("\r\n");
            } else {
                sb.append(0).append("\r\n");
            }
        }
        System.out.println(sb);
    }
}
