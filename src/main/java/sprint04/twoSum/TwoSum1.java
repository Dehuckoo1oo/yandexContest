package sprint04.twoSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoSum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        Set<Integer> ints = new HashSet<>();
        for (int i = 0; i < c; i++) {
            int curInt = Integer.parseInt(tokenizer.nextToken());
            int neededInt = k - curInt;
            if (ints.contains(neededInt)) {
                System.out.println(neededInt + " " + curInt);
                return;
            }
            ints.add(curInt);
        }
        System.out.println("None");
    }
}
