package HashTable;

import java.util.*;
/*
Given an array words of words return the distance between the nearest repeated entries.

If no entry is repeated return -1.
*/

public class NearestRepeatedEntriesInArray {
    public int distanceOfClosestRepeatedEntries(String[] sentence) {
        Map<String, Integer> match = new HashMap<String, Integer>();
        int currentDistance = Integer.MAX_VALUE;
        for (int i = 0; i < sentence.length; i++) {
            if (match.containsKey(sentence[i])) {
                int distance = i - match.get(sentence[i]);
                currentDistance = (distance < currentDistance) ? distance : currentDistance;
            }
            match.put(sentence[i], i);
        }

        return (currentDistance == Integer.MAX_VALUE) ? -1 : currentDistance;
    }
}