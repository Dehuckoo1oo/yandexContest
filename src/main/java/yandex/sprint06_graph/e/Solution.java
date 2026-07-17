package yandex.sprint06_graph.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    private static List<Integer>[] graph;
    // -1 - white, 0 - gray, 1 + i - black;
    private static List<Integer> colors = new ArrayList<>();
    private static int componentCount = 1;

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
            graph[secondV].add(firstV);
        }
        initColor(n);
        for (int i = 1; i <= n; i++) {
            if (colors.get(i) == -1) {
                dfs(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(componentCount - 1).append("\r\n");
        for (int i = 1; i < componentCount; i ++) {
            for (int j = 1; j < colors.size(); j++) {
                if (colors.get(j) == i) {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (colors.get(v) == -1) {
                colors.set(v, 0);
                stack.push(v);
                result.add(v);
                List<Integer> outgoingEdges = getOutgoingEdges(v);
                for (int w : outgoingEdges) {
                    if (colors.get(w) == -1) {
                        stack.push(w);
                    }
                }
            } else if (colors.get(v) == 0) {
                colors.set(v, componentCount);
            }
        }
        componentCount++;
        return result;
    }

    private static List<Integer> getOutgoingEdges(int vertex) {
        return graph[vertex];
    }

    private static void initColor(int n) {
        colors.add(-2);
        for (int i = 0; i < n; i++) {
            colors.add(-1);
        }
    }
}
