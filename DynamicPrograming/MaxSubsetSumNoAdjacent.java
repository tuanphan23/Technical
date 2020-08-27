package DynamicPrograming;
import java.util.*;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int left = array[0];
        int right = Math.max(array[0], array[1]);

        for(int i = 2; i < array.length; i++) {
            int current = Math.max(left + array[i], right);
            left = right;
            right = current;
        }

        return right;
    }
}