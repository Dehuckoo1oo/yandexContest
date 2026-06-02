package yandex.sprint04.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(reader.readLine());
        long x = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long[] nums = new long[c];
        for (int i = 0; i < c; i++) {
            nums[i] = Long.parseLong(tokenizer.nextToken());
        }
        Arrays.sort(nums);
        Set<List<Long>> fours = new HashSet<>();
        for (int i = 0; i < c; i++) {
            for (int j = i + 1; j < c; j++) {
                long[] subArray = Arrays.copyOfRange(nums, j + 1, nums.length);
                long curSum = nums[i] + nums[j];
                List<long[]> halfResult = searchTwoSum(subArray, x - curSum);
                for (long[] curArr : halfResult) {
                    List<Long> curNums = new ArrayList<>();
                    curNums.add(nums[i]);
                    curNums.add(nums[j]);
                    curNums.add(curArr[0]);
                    curNums.add(curArr[1]);
                    Collections.sort(curNums);
                    fours.add(curNums);
                }
            }
        }
        List<List<Long>> foursList = new ArrayList<>(fours);
        foursList.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                int compare = Long.compare(a.get(i), b.get(i));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        });
        System.out.println(foursList.size());
        StringBuilder sb = new StringBuilder();
        for (List<Long> arr : foursList) {
            for (int i = 0; i < 4; i++) {
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }

    public static List<long[]> searchTwoSum(long[] arr, long k) {
        List<long[]> result = new ArrayList<>();
        int size = arr.length;
        int l = 0;
        int r = size - 1;
        while (l < r) {
            long curSum = arr[l] + arr[r];
            if (curSum > k) {
                r--;
            } else if (curSum < k) {
                l++;
            } else {
                result.add(new long[] {arr[l],arr[r]});
                l++;
                r--;
            }
        }
        return result;
    }
}
