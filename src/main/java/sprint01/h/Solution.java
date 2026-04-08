package sprint01.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bitNumber1 = reader.readLine();
        String bitNumber2 = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int bitNumber1Size = bitNumber1.length();
        int bitNumber2Size = bitNumber2.length();
        int maxBitSize = Math.max(bitNumber1Size, bitNumber2Size);
        int bit1Shift = Math.min(0, bitNumber1Size - bitNumber2Size);
        int bit2Shift = Math.min(0, bitNumber2Size - bitNumber1Size);
        int overflow = 0;
        for(int i = maxBitSize - 1; i >= 0; i--) {
            int bit1 = 0;
            int bit2 = 0;
            if (i + bit1Shift >= 0) {
                bit1 = Character.getNumericValue(bitNumber1.charAt(i + bit1Shift));
            }
            if (i + bit2Shift >= 0) {
                bit2 = Character.getNumericValue(bitNumber2.charAt(i + bit2Shift));
            }
            int sum = bit1 + bit2 + overflow;
            overflow = 0;
            if (sum == 0) {
                sb.insert(0, 0);
            }
            if(sum == 1) {
                sb.insert(0, 1);
            }
            if(sum == 2) {
                sb.insert(0,0);
                overflow = 1;
            }
            if (sum == 3) {
                sb.insert(0, 1);
                overflow = 1;
            }
        }
        if(overflow > 0) {
            sb.insert(0, 1);
        }
        System.out.println(sb);
    }
}