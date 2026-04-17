package spring02.c;

class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            return head.next;
        }
        Node<String> curNode = head;
        while (idx - 1 > 0) {
            curNode = curNode.next;
            idx--;
        }
        curNode.next = curNode.next.next;
        return head;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        Node<String> curNode = node0;
        System.out.println(curNode.value);
        while(curNode.next != null) {
            System.out.println(curNode.next.value);
            curNode = curNode.next;
        }
        // result is : node0 -> node2 -> node3
    }

    public static void main(String[] args) {
        test();
    }
}