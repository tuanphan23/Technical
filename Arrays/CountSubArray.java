package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers arr and an integer value k, 
return the total amount of unique, contiguous, subarrays that sum to k in arr.
*/
public class CountSubArray {
    public int countSubarrays(int[] arr, int k) {
        int count = 0;
        int[] cumulativeSum = new int[arr.length];
        cumulativeSum[0] = arr[0];

        for (int i = 1; i <= arr.length - 1; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + arr[i];
        }

        for (int start = 0; start <= arr.length - 1; start++) {
            for (int end = start; end <= arr.length - 1; end++) {
                int tempSum;
                if (start == 0)
                    tempSum = cumulativeSum[end];
                else {
                    tempSum = cumulativeSum[end] - cumulativeSum[start - 1];
                }
                if (tempSum == k)
                    count++;
            }
        }
        return count;
    }

    public int countSubarrays2(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> output = new HashMap<>();
        output.put(0, 1);
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (output.containsKey(cumulativeSum - k)) {
                count += output.get(cumulativeSum - k);
            }

            if (output.containsKey(cumulativeSum)) {
                output.put(cumulativeSum, output.get(cumulativeSum) + 1);
            } else {
                output.put(cumulativeSum, 1);
            }
        }

        return count;
    }
}