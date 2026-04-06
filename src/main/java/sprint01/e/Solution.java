package sprint01.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ethalonStringSize = 0;
        String ethalonString = "";
        int charCount = 0;
        while(charCount < size) {
            String curString = tokenizer.nextToken();
            int stringLength = curString.length();
            if (stringLength > ethalonStringSize) {
                ethalonString = curString;
                ethalonStringSize = stringLength;
            }
            charCount = charCount + stringLength + 1;
        }
        System.out.println(ethalonString);
        System.out.println(ethalonStringSize);
    }
}