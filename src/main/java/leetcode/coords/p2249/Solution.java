package leetcode.coords.p2249;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /*//circles = [[2,2,1]] = 5
    //circles = [[2,2,2],[3,4,1]] = 16
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] circles = new int[][]{{2,2,1}};
        System.out.println(solution.countLatticePoints(circles));
        circles = new int[][]{{2, 2, 2}, {3, 4, 1}};
        System.out.println(solution.countLatticePoints(circles));
    }*/
    public int countLatticePoints(int[][] circles) {
        Set<String> results = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            List<String> coordsInCircle = calcAllCoordsInRadius(x, y, r);
            results.addAll(coordsInCircle);
        }
        return results.size();
    }

    public List<String> calcAllCoordsInRadius(int x, int y, int r) {
        List<String> resultCoords = new ArrayList<>();
        for(int newX = x - r; newX <= x + r; newX++) {
            for(int newY = y - r; newY <= y + r; newY++) {
                int dx = x - newX;
                int dy = y - newY;
                if(dx * dx + dy * dy <= r * r) {
                    resultCoords.add(newX + " " + newY);
                }
            }
        }
        return resultCoords;
    }
}