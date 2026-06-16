package yandex.sprint05.z_final.b;

/*
* Удаление узла из бинарного дерева поиска.
* Ищем узел, который необходимо удалить и его предка:
*   Перебираем все узлы от корня до листов, пока не найдем узел с нужным значением.
*       Если искомое значение меньше текущего значения узла - ищем в левом ребенке, иначе в правом.
*       При каждом переходе запоминаем родителя, чтобы иметь возможность изменить ссылку на родителе, при удалении ребенка.
* Если узел не найден - возвращаем корень дерева.
* Если узел найден логика есть 2 хода решения:
*   Если у удаляемой ноды есть два ребенка, необходимо найти приемника, можно искать самый правый,
*       т.е. максимальный узел у левого ребенка или, как принято - минимальный, т.е. самый левый узел у правого ребенка.
*               >>Я ищу самый левый узел правого ребенка, если такого узла нет - беру правого ребенка.
*       Также, нам нужно знать родителя этого узла, чтобы отвязать в нем ссылку на узел, который будет перемещен выше в иерархии.
*       Заменяем значение у узла, который хотим удалить на значение самого левого узла правого ребенка.
*       Если у самого левого узла правого ребенка был правый ребенок, то этот ребенок должен стать левым ребенком родителя
*       самого левого узла правого ребенка.
*       После этого нода удалена - возвращаем корень дерева.
*     >> как же я не хочу получить такую задачу на собеседовании, надеюсь она очень редкая.
*   Иначе
*       Определяем ребенка, который будет вместо удаляемого узла, т.к. после предыдущего алгоритма мы знаем, что есть
*       только один ребенок - он и займет его место.
*       Если удаляемый узел - не корень, перепривязываем единственного ребенка удаляемого узла к родителю удаляемого узла вместо него.
*       Если удаляемый узел - корень, возвращаем ребенка удаляемого узла как корень дерева.

* */
//Отчет: https://contest.yandex.ru/contest/24810/run-report/162951604/
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
