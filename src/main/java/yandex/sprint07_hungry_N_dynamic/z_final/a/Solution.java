package yandex.sprint07_hungry_N_dynamic.z_final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Отчет: https://contest.yandex.ru/contest/25597/run-report/164079494/
/*
 * prev[j] хранит расстояние Левенштейна между первыми i - 1 символами строки s
 *  и первыми j символами строки t.
 * current[j] хранит расстояние между первыми i символами строки s
 *  и первыми j символами строки t.
 * Для каждой новой строки динамики используется только предыдущая строка,
 *  поэтому хранить всю таблицу dp не требуется.
 * Базовый случай:
 *      prev[j] = j — чтобы получить первые j символов строки t
 *      из пустой строки, нужно выполнить j вставок.
 * Для каждой пары символов:
 *      если символы равны, current[j] = prev[j - 1];
 *      иначе выбирается минимум из:
 *          prev[j] — удаление;
 *          current[j - 1] — вставка;
 *          prev[j - 1] — замена,
 *      и добавляется стоимость одной операции.
 * После вычисления текущей строки массивы prev и current меняются местами.
 * Временная сложность: O(n * m).
 * Пространственная сложность: O(m).
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        int[] prev = new int[t.length() + 1];
        int[] current = new int[t.length() + 1];
        for (int j = 0; j <= t.length(); j++) {
            prev[j] = j;
        }
        for (int i = 1; i <= s.length(); i++) {
            current[0] = i;
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    int deletion = prev[j];
                    int insertion = current[j - 1];
                    int replacement = prev[j - 1];
                    current[j] = 1 + Math.min(deletion, Math.min(insertion, replacement));
                }
            }
            int[] temp = prev;
            prev = current;
            current = temp;
        }
        System.out.println(prev[t.length()]);
    }
}
