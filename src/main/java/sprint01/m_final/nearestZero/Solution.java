package sprint01.m_final.nearestZero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Ссылка на отчет: https://contest.yandex.ru/contest/22450/run-report/160379779/
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] houseNumberArray = new int[count];
        for (int i = 0; i < count; i++) {
            houseNumberArray[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] rightArray = new int[count];
        StringBuilder sb = new StringBuilder();
        int lastZero = Integer.MAX_VALUE;
        for (int i = count - 1; i > -1; i--) {
            if (houseNumberArray[i] == 0) {
                lastZero = i;
            }
            rightArray[i] = lastZero - i;
        }
        /*Такое значение нужно т.к. с Integer.MIN_VALUE возникает проблема с переполнением, если 0 еще не встречался,
        например 0 - (-2147483648) = -2147483648;
        пример в отчете: https://contest.yandex.ru/contest/22450/run-report/160379131/
         */
        lastZero = -2_000_001;
        for (int i = 0; i < count; i++) {
            if (houseNumberArray[i] == 0) {
                lastZero = i;
            }
            sb.append(Math.min(rightArray[i], i - lastZero)).append(" ");
        }
        System.out.println(sb);
    }
}