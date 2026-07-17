package yandex.sprint06_graph.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static List<OutgoingEdge>[] graph;
    private static final int INF = 1_000_000_000;
    private static boolean[] visited;
    private static int[] dist;
    private static Integer[] prev;

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
            int range = Integer.parseInt(tokenizer.nextToken());
            graph[firstV].add(new OutgoingEdge(secondV, range));
            graph[secondV].add(new OutgoingEdge(firstV, range));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            dijkstra(i, n);
            for (int j = 1; j < n + 1; j++) {
                int curDist = dist[j];
                if (curDist == INF) {
                    curDist = -1;
                }
                sb.append(curDist).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int s, int n) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        prev = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = INF;
            prev[i] = null;
        }

        dist[s] = 0;

        while(true) {
            Integer u = getMinDistNotVisitedVertex();
            if (u == null || dist[u] == INF) {
                break;
            }
            visited[u] = true;
            List<OutgoingEdge> neighbours = graph[u];
            for (OutgoingEdge e : neighbours) {
                relax(u, e);
            }
        }
    }

    private static void relax(int u, OutgoingEdge v) {
        if (dist[v.vertex] > dist[u] + v.range) {
            dist[v.vertex] = dist[u] + v.range;
            prev[v.vertex] = u;
        }
    }

    private static Integer getMinDistNotVisitedVertex() {
        Integer currentMinimum = Integer.MAX_VALUE;
        Integer currentMinimumVertex = null;

        for (int v = 1; v < graph.length; v++) {
            if (!visited[v] && dist[v] < currentMinimum) {
                currentMinimum = dist[v];
                currentMinimumVertex = v;
            }
        }
        return currentMinimumVertex;
    }
}

class OutgoingEdge {
    int vertex;
    int range;

    public OutgoingEdge(int vertex, int range) {
        this.vertex = vertex;
        this.range = range;
    }
}
