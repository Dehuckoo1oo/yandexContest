package sprint03.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionWhile {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstSize = Integer.parseInt(reader.readLine());
        int secondSize = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] a = new int[firstSize];
        int[] b = new int[secondSize];
        for (int i = 0; i < firstSize; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < secondSize; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }
        double result = getMedianByTwoSortedArrays(a, b);
        System.out.println(result);
    }

    public static double getMedianByTwoSortedArrays(int[] a, int[] b) {
        if (b.length < a.length) {
            return getMedianByTwoSortedArrays(b, a);
        }

        int n = a.length;
        int m = b.length;

        int total = n + m;
        int leftSize = (total + 1) / 2;

        int left = 0;
        int right = n;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = leftSize - i;

            int leftA = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int rightA = i == n ? Integer.MAX_VALUE : a[i];

            int leftB = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int rightB = j == m ? Integer.MAX_VALUE : b[j];

            if (leftA <= rightB && leftB <= rightA) {
                int maxLeft = Math.max(leftA, leftB);

                if ((total & 1) == 1) {
                    return maxLeft;
                }

                int minRight = Math.min(rightA, rightB);
                return (maxLeft + minRight) / 2.0;
            }

            if (leftA > rightB) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
