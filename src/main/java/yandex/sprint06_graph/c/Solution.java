package yandex.sprint06_graph.c;

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
            int firstVert = Integer.parseInt(tokenizer.nextToken());
            int secondVert = Integer.parseInt(tokenizer.nextToken());
            graph[firstVert].add(secondVert);
            graph[secondVert].add(firstVert);
        }
        int v = Integer.parseInt(reader.readLine());
        initColors(n);
        List<Integer> dfsResult = dfs(v);
        StringBuilder sb = new StringBuilder();
        for (Integer edge : dfsResult) {
            sb.append(edge).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (colors.get(v) == 0) {
                result.add(v);
                colors.set(v, 1);
                stack.push(v);
                List<Integer> outgoingEdges = outgoingEdges(v);
                for (int i = outgoingEdges.size() - 1; i >= 0; i--) {
                    int curEdge = outgoingEdges.get(i);
                    if (colors.get(curEdge) == 0) {
                        stack.push(curEdge);
                    }
                }
            } else if (colors.get(v) == 1) {
                colors.set(v, 2);
            }
        }
        return result;
    }

    private static List<Integer> outgoingEdges(int v) {
        List<Integer> vs = graph[v];
        vs.sort(Integer::compareTo);
        return vs;
    }

    private static void initColors(int n) {
        colors.add(-1);
        for (int i = 0; i < n; i++) {
            colors.add(0);
        }
    }
}
