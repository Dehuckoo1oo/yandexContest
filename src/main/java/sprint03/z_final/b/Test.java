package sprint03.z_final.b;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 9, 1, 20, 5, 3, 10};
        quickSortTest(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortTest(int[] arr, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int pivotPosition = partition(arr, left, right);
        quickSortTest(arr, left, pivotPosition);
        quickSortTest(arr, pivotPosition + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivotIdx = left + random.nextInt(right - left);
        int pivot = arr[pivotIdx];
        swap(arr, pivotIdx, right - 1);
        int curLeft = left;
        int curRight = right - 2;
        while (curLeft <= curRight) {
            while (curLeft <= curRight && arr[curLeft] < pivot) {
                curLeft++;
            }
            while (curRight >= curLeft && arr[curRight] > pivot) {
                curRight--;
            }
            if (curLeft <= curRight) {
                swap(arr, curLeft, curRight);
                curLeft++;
                curRight--;
            }
        }
        swap(arr, curLeft, right - 1);
        return curLeft;
    }

    public static void swap(int[] arr, int firstIdx, int secondIdx) {
        int temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }
}
