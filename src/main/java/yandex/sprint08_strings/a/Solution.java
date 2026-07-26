package yandex.sprint08_strings.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<String> strings = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) {
            strings.add(tokenizer.nextToken());
        }
        strings = strings.reversed();
        StringBuilder sb = new StringBuilder();
        for (String str: strings) {
            sb.append(str).append(" ");
        }
        System.out.println(sb);
    }
}
