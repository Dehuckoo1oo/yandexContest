package leetcode.binarySearchByAnswer.p875;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        Входные данные: piles = [3,6,7,11], h = 8
        Выходные данные: 4
        * */
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        System.out.println(solution.minEatingSpeed(piles, h));
    }

    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 1_000_000_000;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(piles.clone(), h, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int[] piles, int h, int k) {
            int result = 0;
            for (int pile : piles) {
                result += (pile + k - 1) / k;
            }
            if (result > h) {
                return false;
            } else {
                return true;
            }
        }
    }
}
