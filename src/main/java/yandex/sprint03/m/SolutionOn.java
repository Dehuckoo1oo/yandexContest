package yandex.sprint03.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionOn {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstSize = Integer.parseInt(reader.readLine());
        int secondSize = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr1 = new int[firstSize];
        int[] arr2 = new int[secondSize];
        for (int i = 0; i < firstSize; i++) {
            arr1[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < secondSize; i++) {
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int fullSize = firstSize + secondSize;
        int halfSize = fullSize / 2;
        int[] result = getMedianByTwoSortedArrays(arr1, arr2, halfSize);
        if ((fullSize & 1) == 1) {
            System.out.println(result[0]);
        } else {
            System.out.println((result[0] + result[1]) / 2.0);
        }
    }

    public static int[] getMedianByTwoSortedArrays(int[] arr1, int[] arr2, int halfSize) {
        int firstIdx = 0;
        int secondIdx = 0;
        int curResult = -1;
        int prevResult = -1;
        while (firstIdx + secondIdx <= halfSize) {
            int firstElem;
            int secondElem;
            if (firstIdx < arr1.length) {
                firstElem = arr1[firstIdx];
            } else {
                firstElem = Integer.MAX_VALUE;
            }
            if (secondIdx < arr2.length) {
                secondElem = arr2[secondIdx];
            } else {
                secondElem = Integer.MAX_VALUE;
            }
            if (firstElem < secondElem) {
                prevResult = curResult;
                curResult = firstElem;
                firstIdx++;
            } else {
                prevResult = curResult;
                curResult = secondElem;
                secondIdx++;
            }
        }
        return new int[]{curResult, prevResult};
    }
}
