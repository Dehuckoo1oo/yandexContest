package sprint01.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            int strSize = str.length();
            int halfStrSize = strSize / 2;
            int right = strSize - 1;
            for (int left = 0; left < halfStrSize; left++) {
                char leftChar = Character.toLowerCase(str.charAt(left));
                char rightChar = Character.toLowerCase(str.charAt(right));
                while (!Character.isLetterOrDigit(leftChar) && left < halfStrSize - 1) {
                    left++;
                    leftChar = Character.toLowerCase(str.charAt(left));
                }
                while (!Character.isLetterOrDigit(rightChar) && right > halfStrSize + 1) {
                    right--;
                    rightChar = Character.toLowerCase(str.charAt(right));
                }
                if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar) && leftChar != rightChar) {
                    System.out.println("False");
                    return;
                }
                right--;
            }
            System.out.println("True");
    }
}