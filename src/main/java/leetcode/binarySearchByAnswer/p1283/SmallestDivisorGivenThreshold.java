package leetcode.binarySearchByAnswer.p1283;

public class SmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,5,9};
        int threshold = 6;

        System.out.println(solution.smallestDivisor(nums, threshold));
    }


    static class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1;
            int right = 1_000_000;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(nums, threshold, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean check(int[] nums, int threshold, int divisor) {
            int result = 0;
            for (int num : nums) {
                result += (num + divisor - 1) / divisor;
            }
            return result <= threshold;
        }
    }
}


