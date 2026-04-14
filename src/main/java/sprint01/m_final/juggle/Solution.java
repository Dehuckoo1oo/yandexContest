package sprint01.m_final.juggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Ссылка на отчет: https://contest.yandex.ru/contest/22450/run-report/160379852/
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] countersByNumbers = new int[9];
        int k = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int row = 0; row < 4; row++) {
            String str = reader.readLine();
            for (int elem = 0; elem < 4; elem++) {
                char symbol = str.charAt(elem);
                if (symbol != '.') {
                    int number = Character.getNumericValue(symbol);
                    countersByNumbers[number - 1] = countersByNumbers[number - 1] + 1;
                }
            }
        }
        for (int number = 0; number <= 8; number++) {
            if (countersByNumbers[number] <= k * 2 && countersByNumbers[number] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}