package Arrays;

import java.util.*;

/*
Given an array of n integers, return all unique triplets [a,b,c] in the array such that a + b + c = 0.
*/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] A) {
        Arrays.sort(A);

        Set<List<Integer>> allUniqueTriplets = new HashSet<>();

        for (int i = 0; i < A.length - 2; i++) {
            findTwoSum(i, A, allUniqueTriplets);
        }

        return new ArrayList<>(allUniqueTriplets);
    }

    private void findTwoSum(int index, int[] array, Set<List<Integer>> triplets) {
        int left = index + 1;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[index] + array[left] + array[right];

            if (sum == 0) {
                triplets.add(Arrays.asList(array[index], array[left++], array[right--]));
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}