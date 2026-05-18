package sprint04.i;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        arr1[0] = 1;
        arr2[0] = 2;
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(arr1.hashCode() + " " + arr2.hashCode());
        System.out.println((char)('A' + 1));
    }
}
