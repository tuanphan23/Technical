package Searching;

import java.util.*;

/*
Given two sorted arrays, return a new array that represents their intersection. 
*/

public class IntersectionOfTwoSortedArray {
    /*
     * brute force method
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 || nums1[i] != nums1[i - 1]) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        result.add(nums1[i]);
                    }
                }
            }
        }
        return setToArray(result);
    }

    /*
     * Binary search method
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            boolean found = binarySearch(nums2, nums1[i]);

            if (found)
                result.add(nums1[i]);
        }
        return setToArray(result);
    }

    private boolean binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return true;
            else if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }

    /*
     * Two pointer method(linear time)
     */

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                result.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] > nums2[ptr2])
                ptr2++;
            else
                ptr1++;
        }

        return setToArray(result);
    }

    private int[] setToArray(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;
        for (int item : set) {
            array[index] = item;
            index++;
        }
        return array;
    }
}