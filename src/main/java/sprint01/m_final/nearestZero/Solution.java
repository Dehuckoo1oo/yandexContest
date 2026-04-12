package sprint01.m_final.nearestZero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Ссылка на отчет: https://contest.yandex.ru/contest/22450/run-report/160297161/
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] strArray = new int[count];
        for (int i = 0; i < count; i++) {
            strArray[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] rightArray = new int[count];
        StringBuilder sb = new StringBuilder();
        int lastZero = Integer.MAX_VALUE;
        for (int i = count - 1; i > -1; i--) {
            if (strArray[i] == 0) {
                lastZero = i;
            }
            rightArray[i] = lastZero - i;
        }
        lastZero = -2_000_001;
        for (int i = 0; i < count; i++) {
            if (strArray[i] == 0) {
                lastZero = i;
            }
            sb.append(Math.min(rightArray[i], i - lastZero)).append(" ");
        }
        System.out.println(sb);
    }
}