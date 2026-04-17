package spring02.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    private StackMaxEffective stack = new StackMaxEffective();

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
                case "top" -> solution.top();
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

    private void top() {
        Integer item = stack.top();
        if (item == null) {
            System.out.println("error");
        } else {
            System.out.println(item);
        }
    }

}

class StackMaxEffective {
    private final List<Integer> items;
    private final List<Integer> maximums;

    public StackMaxEffective() {
        this.items = new ArrayList<>();
        this.maximums = new ArrayList<>();
    }

    public void push(int value) {
        items.add(value);
        if(maximums.isEmpty()){
            maximums.add(value);
        } else {
            maximums.add(Math.max(maximums.getLast(),value));
        }
    }

    public Integer pop() {
        if (items.isEmpty()) {
            return null;
        }
        int lastItem = items.getLast();
        items.removeLast();
        maximums.removeLast();
        return lastItem;
    }

    public Integer getMax() {
        Integer max = null;
        if(!maximums.isEmpty()) {
            max = maximums.getLast();
        }
        return max;
    }

    public Integer top() {
        if (items.isEmpty()) {
            return null;
        }
        return items.getLast();
    }
}