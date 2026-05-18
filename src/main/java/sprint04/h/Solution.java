package sprint04.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < str.length()) {
            if(set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            } else {
                set.add(str.charAt(right));
                result = Math.max(result, set.size());
                right++;
            }
        }
        System.out.println(result);
    }
}
