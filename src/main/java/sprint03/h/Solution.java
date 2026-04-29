package sprint03.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        String[] numbers = new String[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = tokenizer.nextToken();
        }
        Comparator<String> comparator = (x,y) -> (x + y).compareTo(y + x);
        /*Comparator<String> comparator = (x, y) -> {
            int xY = Integer.parseInt(x + y);
            int yX = Integer.parseInt(y + x);
            return xY - yX;
        };*/
        bubbleSortByComparator(numbers, comparator);
        for (String number : numbers) {
            sb.append(number);
        }
        System.out.println(sb);
    }

    public static void bubbleSortByComparator(String[] intArray, Comparator<String> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < intArray.length - 1; i++) {
                String intToMove = intArray[i];
                if (comparator.compare(intToMove, intArray[i + 1]) < 0) {
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = intToMove;
                    isSorted = false;
                }
            }
        }
    }
}
