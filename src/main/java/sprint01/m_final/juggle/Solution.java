package sprint01.m_final.juggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Ссылка на отчет: https://contest.yandex.ru/contest/22450/run-report/160300441/
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] countersByNumbers = new int[9];
        int k = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < 4; i++) {
            String str = reader.readLine();
            for (int j = 0; j < 4; j++) {
                char symbol = str.charAt(j);
                if (symbol != '.') {
                    int number = Character.getNumericValue(symbol);
                    countersByNumbers[number - 1] = countersByNumbers[number - 1] + 1;
                }
            }
        }
        for (int i = 0; i <= 8; i++) {
            if (countersByNumbers[i] <= k * 2 && countersByNumbers[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}