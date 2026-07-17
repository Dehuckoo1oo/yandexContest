package yandex.sprint07_hungry_N_dynamic.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long n = Long.parseLong(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        long m = Long.parseLong(tokenizer.nextToken());
        List<GoldSand> goldSandList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            long price = Long.parseLong(tokenizer.nextToken());
            long capacity = Long.parseLong(tokenizer.nextToken());
            goldSandList.add(new GoldSand(capacity, price));
        }
        goldSandList.sort((o1, o2) -> Long.compare(o2.price, o1.price));
        long profit = 0;
        for (GoldSand goldSand : goldSandList) {
            long minCapacity = Math.min(goldSand.capacity, n);
            n -= minCapacity;
            profit += goldSand.price * minCapacity;
        }
        System.out.println(profit);
    }

    static class GoldSand {
        long capacity;
        long price;

        GoldSand(long capacity, long price) {
            this.capacity = capacity;
            this.price = price;
        }
    }
}
