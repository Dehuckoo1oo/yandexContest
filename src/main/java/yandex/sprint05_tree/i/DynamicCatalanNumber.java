package yandex.sprint05_tree.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DynamicCatalanNumber {
    public static List<Integer> c = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i <= n; i++) {
            c.add(count(i));
        }
        System.out.println(c.getLast());
    }

    public static int count(int n) {
        if(n < 2) {
            return 1;
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            ans = ans + c.get(left) * c.get(right);
        }
        return ans;
    }
}
