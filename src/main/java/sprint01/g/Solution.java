package sprint01.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number == 0) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int bit = number & 1;
            sb.insert(0, bit);
            number = number >> 1;
        }
        System.out.println(sb);
    }
}