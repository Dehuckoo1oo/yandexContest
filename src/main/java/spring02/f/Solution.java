package spring02.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    private StackMax stack = new StackMax();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        int commandCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            int value = 0;
            if(command.equals("push")) {
                value = Integer.parseInt(tokenizer.nextToken());
            }
            switch (command) {
                case "push" -> solution.push(value);
                case "get_max" -> solution.getMax();
                case "pop" -> solution.pop();
            }
        }
    }

    private void push(int value) {
        stack.push(value);
    }

    private void getMax() {
        Integer max = stack.getMax();
        if(max == null) {
            System.out.println("None");
        } else {
            System.out.println(max);
        }
    }

    private void pop() {
        Integer item = stack.pop();
        if (item == null) {
            System.out.println("error");
        }
    }
}

class StackMax {
    private List<Integer> items;

    public StackMax() {
        this.items = new ArrayList<>();
    }

    public void push(int value) {
        items.add(value);
    }

    public Integer pop() {
        if (items.isEmpty()) {
            return null;
        }
        int lastItem = items.get(items.size() - 1);
        items.remove(items.size() - 1);
        return lastItem;
    }

    public Integer getMax() {
        Integer max = null;
        for (int item : items) {
            if (max == null || max < item) {
                max = item;
            }
        }
        return max;
    }
}