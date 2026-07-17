package yandex.sprint05_tree.b;

public class Solution {

    public static boolean treeSolution(Node head) {
        if (head == null) return true;
        if (head.left == null || head.right == null) {
            if(head.left != null && (head.left.right != null || head.left.left != null)) {
                return false;
            }
            if(head.right != null && (head.right.right != null || head.right.left != null)) {
                return false;
            }
            return true;
        }
        return treeSolution(head.left) && treeSolution(head.right);
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
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}