package sprint01.m_final.nearestZero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int left = -1;
        for (int right = 0; right < count * 2 - 1; right += 2) {

            if (str.charAt(right) == 0 && left != -1) {
                fillDistanceBetweenTwoZeroes(left / 2, right / 2);
            }
            left = right;
        }
    }


public static String fillDistanceBetweenTwoZeroes(int left, int right) {
    StringBuilder sb = new StringBuilder();
    int size = right - left;
    int halfSize = (size + 1) / 2;
    for (int i = 1; i < size; i++) {
        if (i < halfSize) {
            sb.append(i).append(" ");
        } else {
            sb.append(size - i).append(" ");
        }
    }
    return sb.toString();
}
}