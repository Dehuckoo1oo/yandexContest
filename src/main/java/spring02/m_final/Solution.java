package spring02.m_final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        int queueSize = Integer.parseInt(reader.readLine());
        MyDeque deque = new MyDeque(queueSize);
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "push_back" -> deque.pushBack(Integer.parseInt(tokenizer.nextToken()));
                case "push_front" -> deque.pushFront(Integer.parseInt(tokenizer.nextToken()));
                case "pop_front" -> deque.popFront();
                case "pop_back" -> deque.popBack();
            }
        }
    }
}

class MyDeque {
    int[] queue;
    int tailIdx = 0;
    int headIdx = 0;
    int size = 0;
    int maxN;

    public MyDeque(int size) {
        this.queue = new int[size];
        this.maxN = size;
    }

    public void pushBack(int value) {
        if (size < maxN) {
            queue[tailIdx] = value;
            size++;
            tailIdx = (tailIdx + 1) % maxN;
            return;
        }
        System.out.println("error");
    }

    public void pushFront(int value) {
        if(size < maxN) {
            queue[headIdx] = value;
            size++;
            headIdx = (headIdx - 1 + maxN) % maxN;
            return;
        }
        System.out.println("error");
    }

    public void popBack() {
        if (size == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue[(tailIdx -1 + maxN) % maxN]);
        tailIdx = (tailIdx + maxN) % maxN;
        size--;
    }

    public void popFront() {
        if (size == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue[(headIdx) % maxN]);
        headIdx = (headIdx + 1) % maxN;
        size--;
    }
}
