package yandex.sprint03.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int studentsCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] countStudentsByUniversityId = new int[10001];
        for (int i = 0; i < studentsCount; i++) {
            int universityId = Integer.parseInt(tokenizer.nextToken());
            countStudentsByUniversityId[universityId]++;
        }
        int countTopElements = Integer.parseInt(reader.readLine());
        Map<Integer, List<Integer>> universityIdsByCountStudents = new HashMap<>();
        for (int i = 0; i < countStudentsByUniversityId.length; i++) {
            int curCountStudents = countStudentsByUniversityId[i];
            if (curCountStudents != 0) {
                universityIdsByCountStudents.computeIfAbsent(curCountStudents, k -> new ArrayList<>()).add(i);
            }
        }
        int universityAdded = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = studentsCount; i >= 0; i--) {
            List<Integer> curUniversityIds = universityIdsByCountStudents.get(i);
            if(curUniversityIds != null) {
                for(int id : curUniversityIds) {
                    if(universityAdded == countTopElements) {
                        System.out.println(sb);
                        return;
                    }
                    sb.append(id).append(" ");
                    universityAdded++;
                }
            }
        }
        System.out.println(sb);
    }
}
