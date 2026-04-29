package sprint02.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int internNum = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int first = 1;
        int second = 1;
        int curInternNum = 2;
        int sum = 1;
        int powK = 1;
        while(k > 0) {
            powK = powK * 10;
            k--;
        }
        if (internNum == 0 || internNum == 1) {
            System.out.println(1);
            return;
        }
        while (curInternNum <= internNum) {
            sum = (first + second) % powK;
            first = second % powK;
            second = sum;
            curInternNum++;
        }
        System.out.println(sum);
    }
}
