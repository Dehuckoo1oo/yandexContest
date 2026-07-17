package yandex.sprint05_tree.z_final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
/*
* Для хранения данных создал DTO Trainee.
* Для сравнения объектов создал компаратор, сравнение происходит по параметрам:
*   Количество решенных задач - по не возрастанию.
*   Количество штрафных баллов - по не убыванию.
*   Имя стажера в алфавитном порядке.
*
* Организована max-heap через список:
*    Реализовал 2 метода просеивания вверх и вниз:
*       siftUp - сравнивает ребенка по переданному индексу в метод с его родителем.
*           Если ребенок в куче должен стоять перед родителем - меняет их местами,
*           запускается рекурсивно сопровождая актуальный индекс переданный первый раз на входе в метод.
*    
*       siftDown - сравнивает родителя по переданному индексу с его детьми.
*           Из двух детей выбирается тот, что больше.
*           Если выбранный ребенок больше чем родитель - они меняются местами.
*           Рекурсивно проверка повторяется с новым адресом родителя.
*
*   Реализован метод addToHeap для добавления стажеров в max-heap:
*       Метод добавляет элемент в конец списка.
*       По данному адресу применяется метод просеивания вверх,
*       что бы добавленный элемент оказался на своем месте относительно сортировки max-heap.
*     Добавление элемента в конец списка происходит за O(1), просеивание последнего элемента происходит за O(log n)
*       или O(h), где h - высота кучи, т.к. просеивание происходит относительно родителя,
*       к которому попал элемент при добавлении в конец, а не относительно всех элементов в списке.
*
*   Реализован метод popFromHeap для извлечения самого верхнего элемента из max-heap:
*       Метод находит первый элемент в списке и извлекает его за O(1).
*       Чтобы найти следующий элемент, который будет стоять на вершине кучи и частично отсортировать кучу заново,
*       переместим самый последний элемент в куче на вершину O(1) и проведем просеивание данного элемента вниз O(log n).
*
* Решение задачи: Добавить в кучу все элементы поданные на вход в программу.
*                 При добавлении в кучу элементы будут упорядочиваться с помощью просеивания.
*                 Полную сортировку куча не гарантирует, но max-heap гарантирует,
*                 что на вершине куче будет самый большой элемент.
*                 Таким образом мы можем гарантировать сортировку каждый раз забирая из кучи самый большой элемент.
*                 В результате задача сортировки кучей решена за O(n * log n).
* */

//Отчет: https://contest.yandex.ru/contest/24810/run-report/163095462/
public class Solution {

    private static Comparator<Trainee> comparator = (t1, t2) -> {
        int res = Integer.compare(t1.tasks, t2.tasks);
        if (res != 0) return res;
        res = Integer.compare(t2.penalty, t1.penalty);
        if (res != 0) return res;
        res = t2.name.compareTo(t1.name);
        return res;
    };

    private static List<Trainee> heap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        heap.add(null);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        for( int i = 0; i < count; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            addToHeap(new Trainee(tokenizer.nextToken(),
                    Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            Trainee curTrainee = popFromHeap();
            sb.append(curTrainee.name).append("\r\n");
        }
        System.out.println(sb);


    }

    public static int addToHeap(Trainee trainee) {
        heap.add(trainee);
        return siftUp(heap.size() - 1);
    }

    public static Trainee popFromHeap() {
        if (heap.size() < 2) {
            return null;
        }
        Trainee result = heap.get(1);
        Trainee last = heap.removeLast();

        if (heap.size() > 1) {
            heap.set(1, last);
            siftDown(1);
        }
        return result;
    }



    public static int siftUp(int idx) {
        int result = idx;
        int parent = idx / 2;
        if (parent < 1) return idx;
        if (comparator.compare(heap.get(idx), heap.get(parent)) > 0) {
            Trainee temp = heap.get(idx);
            heap.set(idx, heap.get(parent));
            heap.set(parent, temp);
            result = siftUp(parent);
        }
        return result;
    }

    public static int siftDown(int idx) {
        int result = idx;
        int left = idx * 2;
        int right = idx * 2 + 1;
        if (left >= heap.size()) return idx;
        int largestChild = left;
        if (right < heap.size() && comparator.compare(heap.get(right), heap.get(left)) > 0) {
            largestChild = right;
        }
        if (comparator.compare(heap.get(largestChild), heap.get(idx)) > 0) {
            Trainee temp = heap.get(idx);
            heap.set(idx, heap.get(largestChild));
            heap.set(largestChild, temp);
            result = siftDown(largestChild);
        }
        return result;
    }


    static class Trainee {
        String name;
        int tasks;
        int penalty;

        public Trainee(String name, int tasks, int penalty) {
            this.name = name;
            this.tasks = tasks;
            this.penalty = penalty;
        }
    }

}
