package yandex.sprint06_graph.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static List<Integer>[] graph;
    //-1 white; 0 grey; 1 black;
    private static List<Integer> colors = new ArrayList<>();
    private static List<Integer> distance = new ArrayList<>();
    private static List<Integer> prev = new ArrayList<>();


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
        int s = Integer.parseInt(reader.readLine());
        init(n);
        bfs(s);
        int maxDistance = 0;
        for (int curDistance : distance) {
            maxDistance = Math.max(maxDistance, curDistance);
        }
        System.out.println(maxDistance);
    }

    private static List<Integer> bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        colors.set(startVertex, 0);
        distance.set(startVertex, 0);
        prev.set(startVertex, 0);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);
            List<Integer> outgoingEdges = getOutgoingEdges(v);
            for (int w : outgoingEdges) {
                if(colors.get(w) == -1) {
                    colors.set(w, 0);
                    queue.add(w);
                    distance.set(w,distance.get(v) + 1);
                    prev.set(w,v);
                }
            }
            colors.set(v, 1);
        }
        return result;
    }

    private static List<Integer> getOutgoingEdges(int vertex) {
        return graph[vertex];
    }


    private static void init(int n) {
        colors.add(-2);
        prev.add(-1);
        distance.add(-1);
        for (int i = 0; i < n; i++) {
            colors.add(-1);
            distance.add(-1);
            prev.add(-1);
        }
    }
}
