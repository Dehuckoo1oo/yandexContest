package yandex.sprint05_tree.l;

public class Solution {
    public static int siftDown(int[] heap, int idx) {
        int result = idx;
        int left = idx * 2;
        int right = idx * 2 + 1;
        if (left >= heap.length) return idx;
        int largestChild = left;
        if (right < heap.length && heap[right] > heap[left]) {
            largestChild = right;
        }
        if(heap[largestChild] > heap[idx]) {
            int temp = heap[largestChild];
            heap[largestChild] = heap[idx];
            heap[idx] = temp;
            result = siftDown(heap, largestChild);
        }
        return result;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}
