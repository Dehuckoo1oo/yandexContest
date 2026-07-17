package yandex.sprint06_graph.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static List<Integer>[] graph;
    private static List<Integer> colors = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int firstVertex = Integer.parseInt(tokenizer.nextToken());
            int secondVertex = Integer.parseInt(tokenizer.nextToken());
            graph[firstVertex].add(secondVertex);
            graph[secondVertex].add(firstVertex);
        }
        int s = Integer.parseInt(reader.readLine());
        initColor(n);
        List<Integer> result = bfs(s);
        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (colors.get(v) == -1) {
                result.add(v);
                List<Integer> outgoingEdges = getOutgoingEdges(v);
                for (int w : outgoingEdges) {
                    if (colors.get(w) == -1) {
                        queue.add(w);
                    }
                }
                colors.set(v, 1);
            }
        }
        return result;
    }

    private static List<Integer> getOutgoingEdges(int v) {
        List<Integer> outgoingEdges = graph[v];
        outgoingEdges.sort(Integer::compareTo);
        return outgoingEdges;
    }

    private static void initColor(int n) {
        colors.add(-2);
        for (int i = 0; i < n; i++) {
            colors.add(-1);
        }
    }
}
