package sprint03.e;

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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int countHousesNeeded = Integer.parseInt(tokenizer.nextToken());
        int money = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> housesPrice = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            housesPrice.add(Integer.parseInt(tokenizer.nextToken()));
        }
        housesPrice = quickSort(housesPrice);
        int i = 0;
        while (i < housesPrice.size() && housesPrice.get(i) <= money) {
            money = money - housesPrice.get(i);
            i++;
        }
        System.out.println(Math.min(i, countHousesNeeded));
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
        return concatenate(parts[0], parts[1], parts[2]);
    }

    public static List<Integer>[] partition(List<Integer> arr, int pivot) {
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> centerArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        for (Integer elem : arr) {
            if(elem < pivot) {
                leftArr.add(elem);
            } else if (elem == pivot) {
                centerArr.add(elem);
            } else {
                rightArr.add(elem);
            }
        }
        return new List[]{leftArr, centerArr, rightArr};
    }

    public static List<Integer> concatenate(List<Integer> leftArr, List<Integer> centerArr, List<Integer> rightArr) {
        List<Integer> result = new ArrayList<>(leftArr.size() + centerArr.size() + rightArr.size());
        result.addAll(leftArr);
        result.addAll(centerArr);
        result.addAll(rightArr);
        return result;
    }
}
