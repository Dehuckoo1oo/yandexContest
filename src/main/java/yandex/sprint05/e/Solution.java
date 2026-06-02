package yandex.sprint05.e;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static boolean treeSolution(Node head) {
        Queue<Node> queueNode = new ArrayDeque<>();
        Queue<Integer> queueMinMax = new ArrayDeque<>();
        queueNode.add(head);
        queueMinMax.add(Integer.MIN_VALUE);
        queueMinMax.add(Integer.MAX_VALUE);
        while(!queueNode.isEmpty()) {
            Node curNode = queueNode.poll();
            int min = queueMinMax.poll();
            int max = queueMinMax.poll();
            if (curNode.value <= min || curNode.value >= max) {
                return false;
            }
            if (curNode.left != null) {
                queueNode.add(curNode.left);
                queueMinMax.add(min);
                queueMinMax.add(curNode.value);
            }
            if(curNode.right != null) {
                queueNode.add(curNode.right);
                queueMinMax.add(curNode.value);
                queueMinMax.add(max);
            }
        }
        return true;
    }

    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>


    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}
