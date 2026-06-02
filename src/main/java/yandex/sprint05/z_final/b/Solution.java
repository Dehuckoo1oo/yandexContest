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
    public static void main(String[] args) {

    }


    public static Node remove(Node root, int key) {
        if(root == null) return null;
        Node newRoot = root;
        if (root.getValue() == key) {
            newRoot = findMidAndReplace(root, null);
            
        }

        return null;
    }

    private static Node findMidAndReplace(Node node, Node parent) {
        Node result;
        if (node.getLeft() != null && node.getLeft().getRight() != null) {
            result = node.getLeft().getRight();
            while (result.getRight() != null) {
                result = result.getRight();
            }
            return result;
        }
        if (node.getRight() != null && node.getRight().getLeft() != null) {
            result = node.getRight().getLeft();
            while (result.getLeft() != null) {
                result = result.getLeft();
            }
            return result;
        }
        if (node.getLeft() != null) {
            return node.getLeft();
        }
        if(node.getRight() != null) {
            return node.getRight();
        }
        return null;
    }

    private static Node[] findNodeAndParentByKey(Node root, int key) {
        Node curNode = root;
        Node parentNode = null;
        while (curNode != null && curNode.getValue() != key) {
            parentNode = curNode;
            if (curNode.getValue() < key) {
                curNode = curNode.getLeft();
            } else {
                curNode = curNode.getRight();
            }
        }
        return new Node[]{parentNode, curNode};
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
