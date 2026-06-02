package yandex.sprint03.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countSides = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> sidesSize = new ArrayList<>(countSides);
        for (int i = 0; i < countSides; i++) {
            sidesSize.add(Integer.parseInt(tokenizer.nextToken()));
        }
        sidesSize = quickSort(sidesSize);
        for (int i = sidesSize.size() - 1; i >= 2; i--) {
            Integer a = sidesSize.get(i);
            Integer b = sidesSize.get(i - 1);
            Integer c = sidesSize.get(i - 2);
            if (a < b + c) {
                System.out.println(a + b + c);
                return;
            }
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        Random random = new Random();
        int pivot = arr.get(random.nextInt(arr.size()));
        List<Integer>[] parts = partition(arr, pivot);
        parts[0] = quickSort(parts[0]);
        parts[2] = quickSort(parts[2]);
        return concatenate(parts);
    }

    public static List<Integer>[] partition (List<Integer> arr, int pivot) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> centerList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for(Integer elem : arr) {
            if(elem < pivot) {
                leftList.add(elem);
            } else if (elem == pivot) {
                centerList.add(elem);
            } else {
                rightList.add(elem);
            }
        }
        return new List[]{leftList, centerList, rightList};
    }

    public static List<Integer> concatenate(List<Integer>[] parts) {
        List<Integer> result = new ArrayList<>();
        result.addAll(parts[0]);
        result.addAll(parts[1]);
        result.addAll(parts[2]);
        return result;
    }
}
