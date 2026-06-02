package yandex.sprint04.e;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static final Random random = new Random();

    public static void main(String[] args) {
        Map<Long, String> stringsByHashes = new HashMap<>();
        while(true) {
            long hash;
            String str1 = generateRandomString();
            hash = hashCodeByString(str1);
            String str2 = stringsByHashes.get(hash);
            if (str2 != null && !str1.equals(str2)) {
                System.out.println(str1);
                System.out.println(str2);
                return;
            }
            stringsByHashes.put(hash, str1);
        }
    }

    public static long hashCodeByString(String str) {
        long a = 1000;
        long m = 123987123;
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * a + str.charAt(i)) % m;
        }
        return hash;
    }

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            char curChar = (char)('a' + random.nextInt(26));
            sb.append(curChar);
        }
        return sb.toString();
    }
}
