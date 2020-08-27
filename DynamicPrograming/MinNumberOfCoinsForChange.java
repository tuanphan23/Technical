package DynamicPrograming;

import java.util.*;

/*
Given an array of positive integers representing coin denominations and a single non-negative integer n representing 
a target amount of money, write a function that returns the smallest number of coins needed to make change for (to usm up to) 
that target amount using the given coin denominations.

*/

public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] coins = new int[n + 1];
        coins[0] = 0;
        int toCompare = 0;
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.MAX_VALUE; // no coin for change yet
        }

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    int currentNumberOfCoins = coins[amount - denom];
                    toCompare = (currentNumberOfCoins == Integer.MAX_VALUE) ? currentNumberOfCoins
                            : currentNumberOfCoins + 1;
                    coins[amount] = Math.min(coins[amount], toCompare);
                }
            }
        }

        return (coins[n] == Integer.MAX_VALUE) ? -1 : coins[n];
    }
}