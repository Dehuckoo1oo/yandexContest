package yandex.sprint06_graph.z_final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
//Отчет: https://contest.yandex.ru/contest/25070/run-report/163767305/
/*
 * Основной метод считывает карту и сохраняет её в двумерный массив matrix.
 * Массив visited того же размера хранит информацию о том,
 *      какие клетки карты уже были посещены.
 * Метод countIslandsAndGetMaxSizeIsland проходит по всем клеткам карты.
 *  Если встречается непосещённая клетка земли, запускается
 *      итеративный поиск в глубину exploreIsland().
 * Один запуск exploreIsland() обходит один целый остров:
 *      все клетки земли, достижимые по горизонтали и вертикали
 *      из начальной клетки.
 * Для обхода используется стек. При обработке клетки она:
 *      Помечается посещённой;
 *      Учитывается в размере текущего острова;
 *      Её непосещённые соседние клетки земли добавляются в стек.
 * После завершения обхода увеличивается количество островов
 *      и обновляется максимальный найденный размер острова.
 * Временная сложность: O(n * m), где n — количество строк, m — количество столбцов карты.
 * Дополнительная память: O(n * m) на массив visited, карту и стек обхода в худшем случае.
 */
public class Solution {
    private static boolean[][] visited;
    private static char[][] matrix;
    private static int maxIslandSize = 0;
    private static int countIslands = 0;
    private static final int[][] moveCoords = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[n][m];
        matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            matrix[i] = tokenizer.nextToken().toCharArray();
        }
        countIslandsAndGetMaxSizeIsland();
        System.out.println(countIslands + " " + maxIslandSize);
    }

    private static void countIslandsAndGetMaxSizeIsland() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j] && matrix[i][j] == '#') {
                    exploreIsland(i,j);
                }
            }
        }
    }

    private static void exploreIsland(int k, int l) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{k, l});
        int curSize = 0;
        while (!stack.isEmpty()) {
            int[] curCoords = stack.pop();
            int a = curCoords[0];
            int b = curCoords[1];
            if (!visited[a][b] && matrix[a][b] == '#') {
                visited[a][b] = true;
                curSize++;
                List<int[]> neighbours = getNeighbours(a, b);
                for (int[] neighbour : neighbours) {
                    stack.push(neighbour);
                }
            }
        }
        countIslands++;
        maxIslandSize = Math.max(maxIslandSize, curSize);
    }

    private static List<int[]> getNeighbours(int a, int b) {
        List<int[]> result = new ArrayList<>();
        for (int[] move : moveCoords) {
            int newA = a + move[0];
            int newB = b + move[1];
            if (newA > -1 && newB > -1 && newA < matrix.length && newB < matrix[newA].length) {
                if (!visited[newA][newB] && matrix[newA][newB] == '#') {
                    result.add(new int[] {newA, newB});
                }
            }
        }
        return result;
    }
}
