package yandex.sprint04.z_final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* Выбрал простой путь через связный список -> реализовал Node
* Метод hashFunction вычисляет бакет по ключу и модулю, который равен размеру массива.
* Метод put:
*   Принимает ключ и значение, которые нужно поместить в таблицу.
*   По ключу находит бакет куда нужно поместить значение.
*   Если в бакете уже есть ноды ищет нужны по ключу и заменяет значение.
*   Иначе: создает новый узел и помещает его в голову связного списка.
* Метод get:
*   Принимает ключ.
*   По ключу находит бакет где может лежать нужная нода.
*   Перебирает все ноды и сравнивает искомый ключ и ключ ноды, пока не найдет нужную.
*   Если нужная нода найдена - выводит ее, иначе выводит None
* Метод delete:
*   Принимает ключ.
*   По ключу находит бакет где может лежать нужная нода.
*   Перебирает все ноды, сравнивает искомый ключ и ключ ноды, пока не найдет нужную.
*   Если нужная нода найдена:
*       Если это голова списка заменяет голову списка в таблице на следующую ноду и выводит значение текущей ноды
*       Если это середина списка заменяет ссылку у предыдущей ноды на ссылку следующей ноды (исключает текущую)
*       и выводит значение текущей ноды.
*   Иначе: выводит None.
*
* Временная сложность:
* hashFunction работает за O(1).
* put/get/delete в среднем работают за O(1), если ключи равномерно распределены
* по бакетам.
* В худшем случае все ключи попадут в один бакет и сложность всех команд станет O(n).
*
* Пространственная сложность O(n), по идее, это O(1), т.к. мы не меняем размер по условию задачи.
* Но, такая реализация мапы сохранит все ключи, которые будут переданы, хоть и с увеличивающейся
* деградацией из-за коллизий.
* */
//Отчет: https://contest.yandex.ru/contest/24414/run-report/162202548/
public class Solution {
    private static final int SIZE = 200003;
    private static final Node[] table = new Node[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "get" -> get(Integer.parseInt(tokenizer.nextToken()));
                case "put" -> put(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                case "delete" -> delete(Integer.parseInt(tokenizer.nextToken()));
            }
        }
    }


    private static void get(int key) {
        Node curNode = findNode(key);
        if (curNode == null) {
            System.out.println("None");
        } else {
            System.out.println(curNode.value);
        }
    }

    private static void delete(int key) {
        int bucket = hashFunction(key);
        Node curNode = table[bucket];
        Node prevNode = null;

        while (curNode != null) {
            if (curNode.key == key) {
                if (prevNode == null) {
                    table[bucket] = curNode.next;
                } else {
                    prevNode.next = curNode.next;
                }
                System.out.println(curNode.value);
                return;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        System.out.println("None");
    }

    private static void put(int key, int value) {
        int bucket = hashFunction(key);
        Node curNode = table[bucket];

        while (curNode != null) {
            if (curNode.key == key) {
                curNode.value = value;
                return;
            }
            curNode = curNode.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[bucket];
        table[bucket] = newNode;
    }

    private static int hashFunction(int key) {
        int bucket = key % SIZE;
        return bucket < 0 ? bucket + SIZE : bucket;
    }

    private static Node findNode(int key) {
        int bucket = hashFunction(key);
        Node node = table[bucket];
        if (node == null) return null;
        if (node.key == key) return node;
        while (node.next != null) {
            node = node.next;
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }
}

class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
