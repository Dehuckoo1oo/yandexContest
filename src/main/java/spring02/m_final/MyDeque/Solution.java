package spring02.m_final.MyDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* Создал двустороннюю очередь на зацикленном массиве:
* Поля очереди:
*   queue   - массив для хранения данных
*   tailIdx - индекс указывающий куда нужно вставить новое значение при вставке в конец
*   headIdx - индекс указывающий на начало очереди
*   size    - текущий размер очереди
*   maxN    - максимальный размер очереди
* Методы очереди:
*   pushBack:   Принимает значение, которое должно быть записано в конец очереди.
*               Если текущий размер очереди равен или больше максимального размера - выводит ошибку.
*               Иначе: Записывает в массив по индексу tailIdx значение, которое было подано на вход метода.
*                      Увеличивает size на 1.
*                      Увеличивает tailIdx на 1, для записи следующего значения.
*                           Если индекс выходит за пределы массива, для нахождения места вставки используется
*                           остаток от деления индекса (tailIdx) на максимальный размер массива (maxN).
*
*   pushFront:  Принимает значение, которое должно быть записано в начало очереди.
*               Если текущий размер очереди равен или больше максимального размера - выводит ошибку и заканчивает
*               обработку.
*               Иначе: Записывает в массив по индексу headIdx значение, которое было подано на вход метода.
*                      Увеличивает size на 1.
*                      Уменьшает headIdx на 1 для записи следующего значения.
*                           Если индекс выходит за пределы массива, он становится отрицательным,
*                           для нахождения места вставки используется остаток от деления суммы индекса (headIdx) и
*                           максимального размера массива (maxN) на максимальный размер массива (maxN).
*
*   popBack:    Достает значение из конца очереди.
*               Если очередь пустая выводи ошибку.
*               Иначе: Уменьшает size на 1.
*               Выводит значение по индексу tailIdx - 1
*               и перемещает указатель на последний пустой элемент на tailIdx - 1
*               Если индекс выходит за пределы массива, он становится отрицательным, для нахождения корректного индекса
*               используется остаток от деления суммы индекса (tailIdx) и максимального размера массива (maxN) на
*               максимальный размер массива (maxN).
*
*   popFront:    Достает значение из начала очереди.
*                Если очередь пустая выводи ошибку.
*                Иначе: Уменьшает size на 1.
*                Выводит значение по индексу headIdx + 1
*                и перемещает указатель (headIdx) на последний пустой элемент headIdx + 1
*                Если индекс выходит за пределы массива, для нахождения корректного индекса используется остаток от деления
*                индекса (headIdx) на максимальный размер массива (maxN).
* */

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
    int tailIdx = 1;
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
            System.out.println("error");
            return;
        }
        System.out.println(queue[(tailIdx - 1 + maxN) % maxN]);
        tailIdx = (tailIdx - 1 + maxN) % maxN;
        size--;
    }

    public void popFront() {
        if (size == 0) {
            System.out.println("error");
            return;
        }
        System.out.println(queue[(headIdx + 1) % maxN]);
        headIdx = (headIdx + 1) % maxN;
        size--;
    }
}
