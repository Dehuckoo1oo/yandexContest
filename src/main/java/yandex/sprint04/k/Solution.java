package yandex.sprint04.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    private static final Map<String, Integer> busStopCount = new HashMap<>();
    private static final long distance = 20L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer[] metros = new StringTokenizer[n];
        for(int i = 0; i < n; i++) {
            metros[i] = new StringTokenizer(reader.readLine());
        }

        int m = Integer.parseInt(reader.readLine());
        for(int i = 0; i < m; i++) {
            String curBusStop = reader.readLine();
            int sumCount = busStopCount.getOrDefault(curBusStop, 0) + 1;
            busStopCount.put(curBusStop, sumCount);
        }
        int maxCountBus = 0;
        int firstMetroMaxCountBuses = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = metros[i];
            long mX = Integer.parseInt(tokenizer.nextToken());
            long mY = Integer.parseInt(tokenizer.nextToken());
            int countBus = getCountBusStationNearMetro(mX, mY);
            if (countBus > maxCountBus) {
                maxCountBus = countBus;
                firstMetroMaxCountBuses = i;
            }
        }
        System.out.println(firstMetroMaxCountBuses + 1);
    }

    private static int getCountBusStationNearMetro(long mX, long mY) {
        int sumBusStopsCount = 0;
        for (long bX = mX - distance; bX <= mX + distance; bX++) {
            for(long bY = mY - distance; bY <= mY + distance; bY++) {
                long deltaX = mX - bX;
                long deltaY = mY - bY;
                if(deltaX * deltaX + deltaY * deltaY <= distance * distance) {
                    Integer curCountBusStop = busStopCount.get(bX + " " + bY);
                    if(curCountBusStop != null) sumBusStopsCount = sumBusStopsCount + curCountBusStop;
                }
            }
        }
        return sumBusStopsCount;
    }
}
