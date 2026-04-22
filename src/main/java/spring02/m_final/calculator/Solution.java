package spring02.m_final.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
/*
* Создал мапу функций, что бы быстро находить нужную по оператору.
* Стэк с операндами был описан в задании, просто сделал как описано, но, судя по тестам хватило бы и обычной переменной,
* т.к. не встретил записей подобных "1 2 3 4 / * -", везде было только два операнда и потом знак.
* Первый токен - всегда число, его записываем в стэк вначале.
* Пока не кончились токены или стэк не стал пустым:
* Если встретился операнд - добавляю его в стэк
* Если встретился оператор - достаю два операнда и применяю на них функцию, которую нахожу по оператору.
*       Результат сохраняю в стек.
* Когда весь цикл прошел - на вершине остался результат.
* */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Map<String, BiFunction<Integer, Integer, Integer>> operations = Map.of(
                "+", Integer::sum,
                "-", (x, y) -> x - y,
                "/", Math::floorDiv,
                "*", (x, y) -> x * y
        );
        Stack<Integer> operands = new Stack<>();
        operands.add(Integer.parseInt(tokenizer.nextToken()));
        while (tokenizer.hasMoreTokens() && !operands.isEmpty()) {
            String symbol = tokenizer.nextToken();
            if(operations.containsKey(symbol)) {
               int y = operands.pop();
               int x = operands.pop();
               operands.add(operations.get(symbol).apply(x, y));
            } else {
                operands.add(Integer.parseInt(symbol));
            }
        }
        System.out.println(operands.pop());
    }
}
