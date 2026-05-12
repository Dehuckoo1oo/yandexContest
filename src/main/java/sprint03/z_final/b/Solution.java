package sprint03.z_final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * Для сортировки стажеров по количеству выполненных задач(desc), штрафам и именам реализуем in-place quick sort:
 * Создали объект Trainee для хранения данных по каждому стажеру.
 * Создали компаратор для сравнения стажеров по вышеописанному фильтру.
 *
 * Для этой реализации нам потребуется менять два элемента массива по их индексам, для этого создали метод swap.
 *
 * Метод partition:
 * В метод подается массив Trainee, левый индекс, правый индекс, индекс опорного элемента, и компаратор.
 * Меняем местами опорный элемент и крайний правый элемент массива, что бы создать чистый диапазон для сортировки,
 * в котором не участвует опорный элемент.
 * Определяем границы диапазона для сортировки:
 *  Левая граница = левой границе поданной на вход в метод.
 *  Правая граница = элемент слева от опорного (после перемещения).
 * Левую границу смещаем вправо, а правую границу смещаем влево, пока они не встретятся (включая встречу).
 * Если по адресу смещения левой границы в массиве нашли элемент, который должен быть справа от опорного
 * И по адресу смещения правой границы нашли элемент, который должен быть слева от опорного меняем их местами и
 * двигаем левую границу в право, а правую границу влево.
 * Когда левая граница равна правой границе меняем местами опорный элемент с элементом на левой границе.
 * И возвращаем результат правильной позиции опорного элемента - левую границу.
 *
 * Метод quickSortTrainee:
 *  Если список стажеров пуст или состоит из одного элемента, возвращаем список как отсортированный.
 *  Считаем индекс опорного элемента как случайное число между left и right индексами.
 *  С помощью метода partition определяем правильное положение опорного элемента в массиве и сортируем два подмассива
 *  слева и справа от него так, что бы элементы массива слева были меньше опорного, а массива справа были больше опорного.
 *  Применяем метод quickSortTrainee на подмассив слева от опорного элемента.
 *  Применяем метод quickSortTrainee на подмассив справа от опорного элемента.
 *
 * */

//Отчет: https://contest.yandex.ru/contest/23815/run-report/161556028/
public class Solution {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int traineeCount = Integer.parseInt(reader.readLine());
        Trainee[] trainees = new Trainee[traineeCount];
        for (int i = 0; i < traineeCount; i++) {
           StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
           String name = tokenizer.nextToken();
           int successTasks = Integer.parseInt(tokenizer.nextToken());
           int penalty = Integer.parseInt(tokenizer.nextToken());
           trainees[i] = new Trainee(name, successTasks, penalty);
        }
        Comparator<Trainee> comparator = Comparator.comparingInt(Trainee::getSuccessTasksCount).reversed()
                .thenComparingInt(Trainee::getPenalty)
                .thenComparing(Trainee::getName);
        quickSortTrainee(trainees, 0, trainees.length, comparator);
        StringBuilder sb = new StringBuilder();
        for (Trainee trainee : trainees) {
            sb.append(trainee.getName()).append("\r\n");
        }
        System.out.println(sb);
    }

    public static void quickSortTrainee(Trainee[] trainees, int left, int right,
                                        Comparator<Trainee> comparator) {
        if (right - left < 2) {
            return;
        }
        int pivotIdx = left + RANDOM.nextInt(right - left);
        int pivotPosition = partition(trainees, left, right, pivotIdx, comparator);
        quickSortTrainee(trainees, left, pivotPosition, comparator);
        quickSortTrainee(trainees,pivotPosition + 1, right, comparator);
    }

    public static int partition(Trainee[] trainees, int left, int right, int pivotIdx,
                                Comparator<Trainee> comparator) {
        Trainee pivot = trainees[pivotIdx];
        swap(trainees, pivotIdx, right - 1);
        int curLeft = left;
        int curRight = right - 2;
        while (curLeft <= curRight) {
            while (curLeft <= curRight && comparator.compare(trainees[curLeft], pivot) < 0) {
                curLeft++;
            }
            while (curRight >= curLeft && comparator.compare(trainees[curRight], pivot) > 0) {
                curRight--;
            }
            if(curLeft <= curRight) {
                swap(trainees, curLeft, curRight);
                curLeft++;
                curRight--;
            }
        }
        swap(trainees, curLeft, right -1);
        return curLeft;
    }

    public static void swap(Trainee[] arr, int firstIdx, int secondIdx) {
        Trainee temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }
}

class Trainee {
    String name;
    int successTasksCount;
    int penalty;

    public Trainee(String name, int successTasksCount, int penalty) {
        this.name = name;
        this.successTasksCount = successTasksCount;
        this.penalty = penalty;
    }

    public int getSuccessTasksCount() {
        return successTasksCount;
    }

    public int getPenalty() {
        return penalty;
    }

    public String getName() {
        return name;
    }
}
