package sprint01.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int result = 1;
        if (number == 1) {
            System.out.println("True");
            return;
        }
        if (number < 4) {
            System.out.println("False");
            return;
        }
        for (int i = 0; i < 6; i++) {
            result = result << 2;
            if (result == number) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}