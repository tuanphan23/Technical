package Trees;

import java.util.*;

/*
Write a function that takes in two arrays of integers and determines whether these arrays represents the same BST. 
Not that you are not allowed to construct any BSTs in your code.
*/

public class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size())
            return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0)
            return true;
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue())
            return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getEqualOrBigger(arrayOne);
        List<Integer> rightTwo = getEqualOrBigger(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    private static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0)) {
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    private static List<Integer> getEqualOrBigger(List<Integer> array) {
        List<Integer> equalOrBigger = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0)) {
                equalOrBigger.add(array.get(i));
            }
        }
        return equalOrBigger;
    }
}