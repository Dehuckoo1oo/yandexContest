package yandex.sprint06_graph.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    private static List<Integer>[] graph;
    private static final List<Integer> color = new ArrayList<>();
    private static final Stack<Integer> sortedGraph = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int firstV = Integer.parseInt(tokenizer.nextToken());
            int secondV = Integer.parseInt(tokenizer.nextToken());
            graph[firstV].add(secondV);
        }
        initColor(n);
        for (int i = 1; i <= n; i++) {
            if (color.get(i) == 0) {
                dfs(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sortedGraph.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
             int v = stack.pop();
             if (color.get(v) == 0) {
                 color.set(v, 1);
                 result.add(v);
                 stack.push(v);
                 List<Integer> outgoingEdges = getOutgoingEdges(v);
                 for(int w : outgoingEdges) {
                     if (color.get(w) == 0) {
                         stack.push(w);
                     }
                 }
             } else if (color.get(v) == 1) {
                 sortedGraph.push(v);
                 color.set(v, 2);
             }
        }
        return result;
    }

    private static List<Integer> getOutgoingEdges(int vertex) {
        List<Integer> outgoingEdges = graph[vertex];
        outgoingEdges.sort(Integer::compareTo);
        return outgoingEdges;
    }

    private static void initColor(int n) {
        color.add(-1);
        for (int i = 0; i < n; i++) {
            color.add(0);
        }
    }
}
