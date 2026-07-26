package yandex.sprint08_strings.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        String originalString = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        String[] insertions = new String[originalString.length() + 1];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String str = tokenizer.nextToken();
            int pos = Integer.parseInt(tokenizer.nextToken());
            insertions[pos] = str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < originalString.length(); i++) {
            if (insertions[i] != null) {
                sb.append(insertions[i]);
            }
            sb.append(originalString.charAt(i));
        }
        if (insertions[originalString.length()] != null) {
            sb.append(insertions[originalString.length()]);
        }
        System.out.println(sb);
    }
}
