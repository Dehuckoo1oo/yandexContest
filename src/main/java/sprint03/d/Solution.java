package sprint03.d;

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
        int childrenCount = Integer.parseInt(reader.readLine());
        List<Integer> childrenHungry = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int childIdx = 0; childIdx < childrenCount; childIdx++) {
            childrenHungry.add(Integer.parseInt(tokenizer.nextToken()));
        }
        int cookiesCount = Integer.parseInt(reader.readLine());
        List<Integer> cookiesWeight = new ArrayList<>();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int cookieIdx = 0; cookieIdx < cookiesCount; cookieIdx++) {
            cookiesWeight.add(Integer.parseInt(tokenizer.nextToken()));
        }
        childrenHungry = quickSort(childrenHungry);
        cookiesWeight = quickSort(cookiesWeight);
        int hungryIdx = 0;
        int feedIdx = 0;
        int countFedChildren = 0;
        while (hungryIdx < childrenHungry.size()) {
            while (feedIdx < cookiesWeight.size()) {
                if(childrenHungry.get(hungryIdx) <= cookiesWeight.get(feedIdx)) {
                    countFedChildren++;
                    feedIdx++;
                    break;
                }
                feedIdx++;
            }
            hungryIdx++;
        }
        System.out.println(countFedChildren);
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
        List<Integer> leftList = new ArrayList<>();
        List<Integer> centerList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (Integer elem : arr) {
            if (elem < pivot) {
                leftList.add(elem);
            } else if (elem == pivot) {
                centerList.add(elem);
            } else {
                rightList.add(elem);
            }
        }
        return new List[]{leftList, centerList, rightList};
    }

    public static List<Integer> concatenate(List<Integer> leftList, List<Integer> centerList, List<Integer> rightList) {
        List<Integer> resultList = new ArrayList<>(leftList.size() + centerList.size() + rightList.size());
        resultList.addAll(leftList);
        resultList.addAll(centerList);
        resultList.addAll(rightList);
        return resultList;
    }
}
