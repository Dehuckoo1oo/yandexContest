package sprint03.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int daysCount = Integer.parseInt(reader.readLine());
        int[] savings = new int[daysCount];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < daysCount; i++) {
            savings[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int bikePrice = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(findFirstDay(savings, 0, daysCount - 1, bikePrice) + 1).append(" ");
        sb.append(findFirstDay(savings, 0, daysCount - 1, bikePrice * 2) + 1);
        System.out.println(sb);
    }

    public static int findFirstDay(int[] savings, int left, int right, int bikePrice) {
        if (right < left) {
            return -2;
        }
        int midIdx = (right + left) / 2;
        if (savings[midIdx] >= bikePrice) {
            int leftIdx = findFirstDay(savings, left, midIdx - 1, bikePrice);
            if(leftIdx != -2 && savings[leftIdx] >= bikePrice) {
                return leftIdx;
            }
            return midIdx;
        } else {
            int rightIdx = findFirstDay(savings, midIdx + 1, right, bikePrice);
            if(rightIdx != -2 && savings[rightIdx] >= bikePrice) {
                return rightIdx;
            }
        }
        return -2;
    }
}
