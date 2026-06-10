package yandex.sprint05.z_final.b;

class Node {
    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Solution {

    public static Node remove(Node root, int key) {
        Node parent = null;
        Node curNode = root;
        while (curNode != null && curNode.getValue() != key) {
            parent = curNode;
            if (curNode.getValue() > key) {
                curNode = curNode.getLeft();
            } else {
                curNode = curNode.getRight();
            }
        }
        if (curNode == null) return root;

        if (curNode.getLeft() != null && curNode.getRight() != null) {
            Node successorParent = curNode;
            Node successor = curNode.getRight();
            while (successor.getLeft() != null) {
                successorParent = successor;
                successor = successor.getLeft();
            }
            curNode.setValue(successor.getValue());
            Node successorChild = successor.getRight();

            if(successorParent.getLeft() == successor){
                successorParent.setLeft(successorChild);
            } else {
                successorParent.setRight(successorChild);
            }
            return root;
        }
        Node child = null;
        if (curNode.getLeft() != null) {
            child = curNode.getLeft();
        } else {
            child = curNode.getRight();
        }
        if (parent == null) return child;
        if(parent.getLeft() == curNode) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
            return root;
    }


    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}
