package yandex.sprint06_graph.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    //white = 0, grey = 1, black = 2;
    private static final List<Integer> colors = new ArrayList<>();
    private static List<Integer>[] graph;
    private static List<Integer> entry = new ArrayList<>();
    private static List<Integer> leave = new ArrayList<>();

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
        initCollections(n);
        int v = 1;
        dfs(v);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(entry.get(i)).append(" ").append(leave.get(i)).append("\r\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(startVertex);
        int t = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (colors.get(v) == 0) {
                result.add(v);
                colors.set(v, 1);
                entry.set(v,t);
                t += 1;
                stack.push(v);
                List<Integer> outgoingEdges = getOutgoingEdges(v);
                for (int i = outgoingEdges.size() - 1; i >= 0; i--) {
                    int w = outgoingEdges.get(i);
                    if (colors.get(w) == 0) {
                        stack.push(w);
                    }
                }
            } else if (colors.get(v) == 1) {
                leave.set(v, t);
                t += 1;
                colors.set(v, 2);
            }
        }
        return result;
    }

    private static List<Integer> getOutgoingEdges(int v) {
        List<Integer> outgoingEdges = graph[v];
        outgoingEdges.sort(Integer::compareTo);
        return outgoingEdges;
    }

    private static void initCollections(int n) {
        colors.add(-1);
        entry.add(-1);
        leave.add(-1);
        for (int i = 0; i < n; i++) {
            colors.add(0);
            entry.add(-1);
            leave.add(-1);
        }
    }
}
