package yandex.sprint07_hungry_N_dynamic.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>((t1, t2) -> {
            int result = Float.compare(t1.to, t2.to);
            if(result != 0) {
                return result;
            }
            return Float.compare(t1.from, t2.from);
        });
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            Task task = new Task(Float.parseFloat(tokenizer.nextToken()), Float.parseFloat(tokenizer.nextToken()));
            priorityQueue.add(task);
        }
        float curHour = 0.0F;
        List<Task> acceptedTasks = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            if (task.from >= curHour) {
                acceptedTasks.add(task);
                curHour = task.to;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(acceptedTasks.size()).append("\r\n");
        for (Task task : acceptedTasks) {
            sb.append(task.from).append(" ").append(task.to).append("\r\n");
        }
        System.out.println(sb);
    }

    static class Task {
        float from;
        float to;

        Task(float from, float to) {
            this.from = from;
            this.to = to;
        }
    }
}
