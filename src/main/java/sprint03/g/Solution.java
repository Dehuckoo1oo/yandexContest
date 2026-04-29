package sprint03.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countClothTotal = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] clothCounter = new int[3];
        for(int i = 0; i < countClothTotal; i++) {
            clothCounter[Integer.parseInt(tokenizer.nextToken())]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < clothCounter.length; i++) {
            int numberCount = clothCounter[i];
            for (int j = 0; j < numberCount; j++) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
