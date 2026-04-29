package sprint02.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        NodeQueue queue = new NodeQueue();
        for(int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "get" -> queue.get();
                case "put" -> queue.put(Integer.parseInt(tokenizer.nextToken()));
                case "size" -> queue.size();
            }
        }
    }
}

class NodeQueue {
    Node head;
    Node tail;
    int size;

    void put(int value) {
        Node curNode = new Node(value);
        if (tail == null) {
            tail = curNode;
        } else {
            tail.nextNode = curNode;
            tail = tail.nextNode;
        }
        if (head == null) {
            head = tail;
        }
        size++;
    }

    void get() {
        if (head == null) {
            System.out.println("error");
            return;
        }
        int result = head.value;
        if (head.nextNode != null) {
            head = head.nextNode;
        } else {
            head = null;
        }
        System.out.println(result);
        size--;
    }

    void size() {
        System.out.println(size);
    }
}

class Node {
    int value;
    Node prevNode;
    Node nextNode;

    public Node(int value) {
        this.value = value;
    }
}
