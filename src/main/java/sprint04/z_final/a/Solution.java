package sprint04.z_final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* Строим поисковый индекс по входящим документам, по каждому слову - в каком документе и сколько раз встречался.
* В каждом запросе собираем только уникальные слова.
* По каждому слову запроса, из поискового индекса собираем: в какие документы и сколько раз оно входит.
* Группируем по текущему запросу документ : число вхождений, суммируя число вхождений по каждому слову документа.
* Сортируем документы по числу вхождений в порядке неубывания, если число вхождений одинаковое,
* сортируем по индексу документа в порядке возрастания.
* Выводим первые 5 элементов, если их меньше - выводим все.
* */

//Отчет: https://contest.yandex.ru/contest/24414/run-report/162196565/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<Integer, Integer>> wordToDocIdxAndCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                String curStr = tokenizer.nextToken();
                Map<Integer, Integer> curMap = wordToDocIdxAndCount.computeIfAbsent(curStr, v -> new HashMap<>());
                curMap.put(i, curMap.getOrDefault(i, 0) + 1);
            }
        }
        int m = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            Set<String> uniqueRequestWords = new HashSet<>();
            Map<Integer, Integer> sumCountWordsByDoc = new HashMap<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                uniqueRequestWords.add(tokenizer.nextToken());
            }
            for (String curWord : uniqueRequestWords) {
                Map<Integer, Integer> foundWords = wordToDocIdxAndCount.get(curWord);
                if (foundWords != null) {
                    for (Map.Entry<Integer, Integer> curEntry : foundWords.entrySet()) {
                        int docIdx = curEntry.getKey();
                        int count = curEntry.getValue();
                        int curCount = sumCountWordsByDoc.getOrDefault(docIdx, 0);
                        sumCountWordsByDoc.put(docIdx, curCount + count);
                    }
                }
            }
            List<Map.Entry<Integer,Integer>> countByIdxDocs = new ArrayList<>(sumCountWordsByDoc.entrySet());
            countByIdxDocs.sort((doc1, doc2) -> {
                int comparator = Integer.compare(doc2.getValue(), doc1.getValue());
                if (comparator != 0) {
                    return comparator;
                }
                return Integer.compare(doc1.getKey(), doc2.getKey());
            });
            int minDocsToPrint = Math.min(countByIdxDocs.size(), 5);
            for (int curDocIdx = 0; curDocIdx < minDocsToPrint; curDocIdx++) {
                sb.append(countByIdxDocs.get(curDocIdx).getKey() + 1).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }
}
