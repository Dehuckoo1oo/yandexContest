package yandex.sprint06_graph.z_final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Отчет: https://contest.yandex.ru/contest/25070/run-report/163662787/
/*
 * Граф хранится в виде списка смежности: для каждой вершины сохраняются все
 *      выходящие из неё рёбра и их веса. Поскольку граф неориентированный,
 *      каждое ребро добавляется в списки смежности обеих вершин.
 * Массив added отмечает вершины, которые уже включены в остовное дерево.
 *      Очередь с приоритетом edges хранит рёбра, ведущие из построенной части
 *      остова к ещё не добавленным вершинам.
 * В обычном алгоритме Прима выбирается ребро с минимальным весом.
 *      В этой задаче требуется максимальное остовное дерево, поэтому PriorityQueue
 *      настроена так, чтобы первой извлекалось ребро с максимальным весом.
 * Алгоритм начинается с вершины 1:
 *      Вершина добавляется в остов.
 *      Все её рёбра, ведущие в ещё не добавленные вершины, помещаются в очередь.
 *      Из очереди извлекается самое тяжёлое ребро.
 *      Если конечная вершина ребра уже добавлена, ребро пропускается,
 *      поскольку его добавление создало бы цикл.
 *      Иначе вес ребра прибавляется к результату, а новая вершина
 *      включается в остов вместе с её подходящими рёбрами.
 * Процесс продолжается, пока не будут добавлены все вершины, либо пока
 *      очередь рёбер не станет пустой.
 * Если удалось добавить n вершин, построено максимальное остовное дерево,
 *      и метод возвращает его суммарный вес. Если добавлено меньше n вершин,
 *      исходный граф несвязный, поэтому остовного дерева не существует.
 * Временная сложность: O(m log m), где m — количество рёбер.
 */
public class Solution {
    private static List<OutgoingEdge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        init(n);
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int firstV = Integer.parseInt(tokenizer.nextToken());
            int secondV = Integer.parseInt(tokenizer.nextToken());
            int range = Integer.parseInt(tokenizer.nextToken());
            graph[firstV].add(new OutgoingEdge(secondV, range));
            graph[secondV].add(new OutgoingEdge(firstV, range));
        }
        Long result = findMaximumSpanningTreeWeight(n);

        if (result == null) {
            System.out.println("Oops! I did it again");
        } else {
            System.out.println(result);
        }
    }

    private static Long findMaximumSpanningTreeWeight(int n) {
        boolean[] added = new boolean[n + 1];
        PriorityQueue<OutgoingEdge> edges = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.range, e1.range)
        );
        long totalWeight = 0;
        int addedCount = 0;
        addVertex(1, added, edges);
        addedCount++;
        while (addedCount < n && !edges.isEmpty()) {
            OutgoingEdge edge = edges.poll();
            if (added[edge.vertex]){
                continue;
            }
            totalWeight += edge.range;

            addVertex(edge.vertex, added, edges);
            addedCount++;
        }
        if (addedCount != n) {
            return null;
        }
        return totalWeight;
    }

    private static void addVertex(int vertex, boolean[] added, PriorityQueue<OutgoingEdge> edges) {
        added[vertex] = true;
        for (OutgoingEdge edge : graph[vertex]) {
            if (!added[edge.vertex]) {
                edges.add(edge);
            }
        }
    }


    private static void init(int n) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static List<OutgoingEdge> getOutgoingEdges(int vertex) {
        return graph[vertex];
    }

    static class OutgoingEdge {
        int vertex;
        int range;

        public OutgoingEdge(int vertex, int range) {
            this.vertex = vertex;
            this.range = range;
        }
    }
}


