package yandex.sprint05.m;

public class Solution {

    public static int siftUp(int[] heap, int idx) {
        int parent = idx / 2;
        int result = idx;
        if (parent < 1) return idx;
        if (heap[idx] > heap[parent]) {
            int temp = heap[idx];
            heap[idx] = heap[parent];
            heap[parent] = temp;
            result = siftUp(heap, parent);
        }
        return result;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }
}
