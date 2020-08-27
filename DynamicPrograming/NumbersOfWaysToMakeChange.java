package DynamicPrograming;

import java.util.*;

/*
Given an array of distinct positive integers representing coin denominations of a single non-negative integer n representing
a target amount of money, write a function that returns the number of ways to make change for that target amount using the giving coin denominations.

*/

public class NumbersOfWaysToMakeChange {
    public static int NumbersOfWaysToMakeChange(int n, int[] denominations) {
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denominations) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }
}