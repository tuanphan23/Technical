package Searching;

import java.util.*;

/*
Given a rotated sorted array, find the minimum element.

A "rotated" array is an array that has had each item shifted to the left or right by k units 
(where k is a positive integer) while maintaining positional integrity of every element in the original array.
*/

public class MinimumItemInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            if (nums[mid] < nums[right])
                right = mid;
        }
        if (nums.length != 0) {
            return nums[left];
        } else
            return -1;
    }
}