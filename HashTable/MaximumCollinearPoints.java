package HashTable;

import java.util.*;
/*
Given an array of distinct points in 2D space, find the maximum number of points that lie on the same line.
*/

public class MaximumCollinearPoints {
    public int maximumCollinearPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int answer = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int gdc = greatestCommonDivisor(dx, dy);
                dx /= gdc;
                dy /= gdc;

                String slope = Integer.toString(dy) + "/" + Integer.toString(dx);
                int count = slopes.getOrDefault(slope, 0);
                slopes.put(slope, count + 1);
            }
            for (Map.Entry<String, Integer> entry : slopes.entrySet()) {
                answer = Math.max(entry.getValue() + 1, answer);
            }
        }

        return answer;
    }

    private int greatestCommonDivisor(int dx, int dy) {
        while (dx != 0 && dy != 0) {
            if (dx > dy) {
                dx %= dy;
            } else {
                dy %= dx;
            }
        }
        return (dx == 0) ? dy : dx;
    }
}