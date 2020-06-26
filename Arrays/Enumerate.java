package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer value n, enumerate all prime numbers from 1 to n (exclusive) and 
return the list with the enumeration.
*/

public class Enumerate {
    public List<Integer> enumeratePrimes(int n) {
        if (n < 2)
            return new ArrayList<>();
        int i = 2;
        List<Integer> output = new ArrayList<>();
        while (i < n) {
            int j = 2;
            boolean isPrime = true;
            while (j < i) {
                if (i % j == 0) {
                    isPrime = false;
                }
                j++;
            }

            if (isPrime)
                output.add(i);
            i++;
        }

        return output;
    }

    /*
     * Time: O(n^2) Space: O(n)
     */

    public List<Integer> enumeratePrimes2(int n) {
        if (n < 2)
            return new ArrayList<>();

        boolean[] isPrime = new boolean[n];
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < n; i++) { /* O(n) */
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 0; i < n; i++) { /* O(n) */
            if (isPrime[i]) {
                for (int j = i + i; j < n; j += i) { /* O(log(logn)) */
                    isPrime[j] = false;
                }

                output.add(i);
            }
        }
        return output;
    }

    /*
     * Time: O(nloglogn) Space: O(n)
     */
}