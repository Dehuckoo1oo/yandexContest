package sprint02.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int internNum = Integer.parseInt(reader.readLine());
        int first = 1;
        int second = 1;
        int cutInternNum = 2;
        if (internNum == 0 || internNum == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(calculateCommitsByIntern(first, second, internNum, cutInternNum));
    }

    private static int calculateCommitsByIntern(int first, int second, int finalInternNum, int cutInternNum) {
        int sum = first + second;
        if (cutInternNum == finalInternNum) {
            return sum;
        }
        return calculateCommitsByIntern(second, sum, finalInternNum, cutInternNum + 1);
    }
}
