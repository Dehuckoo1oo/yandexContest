package sprint01.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        List<Integer> primes = getSmallerPrimes(number);
        List<Integer> result = new ArrayList<>();
        List<Integer> filteredPrimes = primes.stream().filter(v -> number % v == 0).toList();
    }

    public static List<Integer> getSmallerPrimes(int n) {
        List<Integer> smallerPrimes = new ArrayList<>();
        for (int num = 2; num <= n; num++) {
            if (isPrime(num)) {
                smallerPrimes.add(num);
            }
        }
        return smallerPrimes;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
}