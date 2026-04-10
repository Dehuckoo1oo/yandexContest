package sprint01.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String number1 = reader.readLine();
        String number2 = reader.readLine();
        int number1Size = number1.length();
        int number2Size = number2.length();
        int indexNum1 = number1Size - 1;
        int indexNum2 = number2Size - 1;
        int maxIndex = Math.max(count, number2Size);
        int overflow = 0;
        StringBuilder sb = new StringBuilder();
        while (maxIndex > 0) {
            int a = 0;
            int b = 0;
            if (indexNum1 >= 0) {
                a = Character.getNumericValue(number1.charAt(indexNum1));
            }
            if (indexNum2 >= 0) {
                b = Character.getNumericValue(number2.charAt(indexNum2));
            }
            int sum = a + b + overflow;
            overflow = 0;
            if (sum >= 10) {
                overflow = sum / 10;
                sum = sum % 10;
            }
            sb.append(sum).append(" ");
            indexNum1 -= 2;
            indexNum2--;
            maxIndex--;
        }
        if (overflow > 0) {
            sb.append(overflow);
        }
        sb.reverse();
        System.out.println(sb);
    }
}