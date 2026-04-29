package sprint03.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        boolean wasPrinted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    int buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                }
            }
            if (!isSorted) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) {
                    sb.append(num).append(" ");
                }
                wasPrinted = true;
                System.out.println(sb);
            }
            if (!wasPrinted) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }
        }
    }
}
