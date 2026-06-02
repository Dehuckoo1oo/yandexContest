package yandex.sprint04.z_final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Строим инвертированный индекс документов "слово -> (индекс документа -> количество вхождений)".
 * В рамках каждого запроса:
 * Считываем слова из запроса в HashSet, чтобы обрабатывать только уникальные слова.
 * По каждому уникальному слову из запроса находим документ, где оно встречается и количество вхождений слова в этот
 * документ.
 * Суммируем вхождения каждого слова по документам, получаем структуру:
 *  "документ -> количество вхождений всех уникальных слов из запроса"
 * Сортируем документы по количеству вхождений в порядке не возрастания и по индексу документа.
 * Выводим первые 5 документов, если документов меньше 5, выводим все имеющиеся.
 *
 * Сложность алгоритма:
 *      Построение индекса занимает O(суммарное количество слов во всех документах) времени
 *      и O(суммарное количество слов во всех документах) памяти.
 *  Для одного запроса:
 *  u — количество уникальных слов в запросе;
 *  k — суммарное количество записей в индексе для этих слов;
 *  d — количество документов с положительной релевантностью.
 *  Обработка запроса занимает O(u + k + d log(d)) времени
 *  и O(u + d) дополнительной памяти.
 *  В худшем случае d может быть равно n.
 * */

//Отчет: https://contest.yandex.ru/contest/24414/run-report/162257879/
public class Solution {
    private static final int RESULT_LIMIT_DOCS = 5;

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
            int minDocsToPrint = Math.min(countByIdxDocs.size(), RESULT_LIMIT_DOCS);
            for (int curDocIdx = 0; curDocIdx < minDocsToPrint; curDocIdx++) {
                sb.append(countByIdxDocs.get(curDocIdx).getKey() + 1).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }
}
