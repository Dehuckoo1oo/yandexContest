package yandex.sprint04.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(reader.readLine());
        long m = Long.parseLong(reader.readLine());
        String str = reader.readLine();
        int c = Integer.parseInt(reader.readLine());
        long[] idxToHash = new long[str.length() + 1];
        long[] pow = new long[str.length() + 1];
        pow[0] = 1;
        idxToHash[0] = 0;
        long hash = 0;
        for(int i = 1; i <= str.length(); i++) {
            hash = (hash * a + str.charAt(i - 1)) % m;
            idxToHash[i] = hash;
            pow[i] = (pow[i - 1] * a) % m;
        }
        for (int i = 0; i < c; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            long curHash = (idxToHash[r] - idxToHash[l - 1] * pow[r - l + 1]) % m;
            curHash = (curHash + m) % m;
            System.out.println(curHash);
        }
    }
}
