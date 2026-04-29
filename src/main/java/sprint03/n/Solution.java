package sprint03.n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int workerCount = Integer.parseInt(reader.readLine());
        int[][] flowersArray = new int[workerCount][2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < workerCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            flowersArray[i][0] = Integer.parseInt(tokenizer.nextToken());
            flowersArray[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        mergeSort(flowersArray);
        int[] prevArray = flowersArray[0];
        for (int i = 1; i < flowersArray.length; i++) {
            int[] curArray = flowersArray[i];
            if (prevArray[1] >= curArray[0]) {
                int maxEnd = Math.max(curArray[1],prevArray[1]);
                prevArray = new int[]{prevArray[0], maxEnd};
            } else {
                sb.append(prevArray[0]).append(" ").append(prevArray[1]).append("\r\n");
                prevArray = curArray;
            }
        }
        sb.append(prevArray[0]).append(" ").append(prevArray[1]).append("\r\n");
        System.out.println(sb);
    }

    public static int[][] mergeSort (int[][] arr) {
        if (arr.length == 1 || arr.length ==0) {
            return arr;
        }
        int[][] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[][] rightArr = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        int l = 0;
        int r = 0;
        int k = 0;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l][0] <= rightArr[r][0]) {
                arr[k] = leftArr[l];
                l++;
            } else {
                arr[k] = rightArr[r];
                r++;
            }
            k++;
        }
        while (l < leftArr.length) {
            arr[k] = leftArr[l];
            l++;
            k++;
        }
        while (r < rightArr.length) {
            arr[k] = rightArr[r];
            r++;
            k++;
        }
        return arr;
    }
}
