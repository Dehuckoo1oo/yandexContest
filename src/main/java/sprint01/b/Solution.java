package sprint01.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
            StringBuilder output_buffer = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            if (((aBit ^ bBit) | (bBit ^ cBit)) == 0) {
                System.out.println("WIN");
            } else {
                System.out.println("FAIL");

            }
    }
}