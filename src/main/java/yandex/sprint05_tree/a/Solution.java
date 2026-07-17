package yandex.sprint05_tree.a;

public class Solution {
    public static int treeSolution(Node head) {
        if (head == null) return -1;
        int left = treeSolution(head.left);
        int right = treeSolution(head.right);
        int childMax = Math.max(left,right);
        return Math.max(childMax, head.value);
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
    }
    // <template>


    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
