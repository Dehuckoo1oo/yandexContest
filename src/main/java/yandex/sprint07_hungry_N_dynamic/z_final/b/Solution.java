package yandex.sprint07_hungry_N_dynamic.z_final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Отчет: https://contest.yandex.ru/contest/25597/run-report/163998615/
/*
 * Массив dp хранит информацию о достижимых суммах dp[sum] = true,
 *      если сумму sum можно получить из уже рассмотренных элементов массива.
 * Изначально достижима только сумма 0.
 * Затем последовательно обрабатывается каждый элемент массива.
 * Для каждого элемента массив dp обновляется справа налево:
 *      если сумма sum - current уже достижима,то после добавления текущего элемента достижимой становится и сумма sum.
 * После обработки всех элементов нужно проверить, достижима ли сумма, равная половине общей суммы массива.
 *      Если да, массив можно разделить на две части с одинаковой суммой.
 *      Если общая сумма нечётная или половина суммы недостижима, такое разбиение невозможно.
 * Временная сложность: O(n * target),
 *      где n — количество элементов,
 *      target — половина общей суммы массива.
 * Пространственная сложность: O(target).
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] numbers = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
            totalSum += numbers[i];
        }
        if (totalSum % 2 != 0) {
            System.out.println("False");
            return;
        }
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int number : numbers) {
            for (int sum = target; sum >= number; sum--) {
                dp[sum] |= dp[sum - number];
            }
        }
        System.out.println(dp[target] ? "True" : "False");
    }
}