package sprint04.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Set<String> strings = new TreeSet<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String curStr = reader.readLine();
            if(!strings.contains(curStr)) {
                stringList.add(curStr);
            }
            strings.add(curStr);
        }
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}
