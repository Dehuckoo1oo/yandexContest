package sprint02.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        MyQueueSized queue = new MyQueueSized(size);
        for (int rowNum = 0; rowNum < count; rowNum++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            String command = stringTokenizer.nextToken();
            int value = 0;
            if (command.equals("push")) {
                value = Integer.parseInt(stringTokenizer.nextToken());
            }
            switch (command) {
                case "push" -> queue.push(value);
                case "pop" -> queue.pop();
                case "peek" -> queue.peek();
                case "size" -> queue.size();
            }
        }
    }
}

class MyQueueSized {
    private int[] queue;
    private int tail = 0;
    private int head = 0;
    private int size = 0;
    private int max_n;

    public MyQueueSized(int size) {
        this.queue = new int[size];
        this.max_n = size;
    }

    public void push(int value) {
        if (size < max_n) {
            queue[tail] = value;
            tail = (tail + 1) % max_n;
            size++;
            return;
        }
        System.out.println("error");
    }

    public void pop() {
        if (size == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue[head]);
        head = (head + 1) % max_n;
        size--;
    }

    public void peek() {
        if (size == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue[head]);
    }

    public void size() {
        System.out.println(size);
    }
}
