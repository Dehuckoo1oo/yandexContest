package sprint04.twoSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int[] ints = new int[c];
        for (int i = 0; i < c; i++) {
            ints[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int l = 0;
        int r = c - 1;
        while (l < r) {
            int curSum = ints[l] + ints[r];
            if(curSum > k) {
                r--;
            } else if (curSum < k) {
                l++;
            } else {
                System.out.println(ints[l] + " " + ints[r]);
                return;
            }
        }
        System.out.println("None");
    }
}
