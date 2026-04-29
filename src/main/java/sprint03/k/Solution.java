package sprint03.k;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int l = 0;
        int r = 0;
        int k = 0;
        int[] leftArray = Arrays.copyOfRange(arr, left,mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, right);
        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] <= rightArray[r]) {
                arr[left + k] = leftArray[l];
                l++;
            } else {
                arr[left + k] = rightArray[r];
                r++;
            }
            k++;
        }
        while (l < leftArray.length) {
            arr[left + k] = leftArray[l];
            l++;
            k++;
        }
        while (r < rightArray.length) {
            arr[left + k] = rightArray[r];
            r++;
            k++;
        }
        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        int size = right - left;
        int mid = (left + right) / 2;
        if(size == 1 || size == 0) {
            return;
        }
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
