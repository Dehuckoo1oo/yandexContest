package sprint01.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        if(size == 1) {
            System.out.println(1);
            return;
        }
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int counter = 0;
        int lastTemp = Integer.parseInt(tokenizer.nextToken());
        int curTemp = Integer.parseInt(tokenizer.nextToken());
        int nextTemp;
        if (lastTemp > curTemp) {
            counter++;
        }
        for (int i = 2; i < size; i++) {
            nextTemp = Integer.parseInt(tokenizer.nextToken());
            if (curTemp > lastTemp && curTemp > nextTemp) {
                counter++;
            }
            lastTemp = curTemp;
            curTemp = nextTemp;
        }
        if (curTemp > lastTemp) {
            counter++;
        }
        System.out.println(counter);
    }
}