package yandex.sprint04.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int BASE = 257;
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums1 = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.parseInt(tokenizer.nextToken());
        }
        long[] prefix1 = calcPrefixHash(nums1);
        long[] prefix2 = calcPrefixHash(nums2);

        int maxLength = Math.max(n,m);
        long[] pow = new long[maxLength + 1];
        pow[0] = 1;
        for(int i = 1; i <= maxLength; i++) {
            pow[i] = (pow[i - 1] * BASE) % MOD;
        }
        int left = 0;
        int right = Math.min(n,m);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if(check(mid, prefix1, prefix2, pow)) {
                left = mid;
            } else {
                right = mid -1;
            }
        }
        System.out.println(left);
    }

    public static boolean check(int len, long[] prefix1, long[] prefix2, long[] pow) {
        Set<Long> hashes = new HashSet<>();
        for (int i = 0; i + len < prefix1.length; i++) {
            hashes.add(getHash(prefix1, pow, i, i + len));
        }

        for(int i = 0; i + len < prefix2.length; i++) {
            long hash = getHash(prefix2, pow, i, i + len);
            if(hashes.contains(hash)){
                return true;
            }
        }
        return false;
    }

    public static long getHash(long[] prefix, long[] pow, int l, int r ) {
        return (prefix[r] - prefix[l] * pow[r - l] % MOD + MOD) % MOD;
    }

    public static long[] calcPrefixHash(int[] arr) {
        long[] hashArr = new long[arr.length + 1];
        long hash = 0;
        hashArr[0] = hash;
        for(int i = 1; i < arr.length + 1; i++) {
            hash = (hash * BASE + arr[i - 1] + 1) % MOD;
            hash = (hash + MOD) % MOD;
            hashArr[i] = hash;
        }
        return hashArr;
    }
}
