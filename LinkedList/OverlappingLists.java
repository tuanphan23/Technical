package LinkedList;

import java.util.*;

public class OverlappingLists {
    // Using a Set
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        Set<ListNode> setMatching = new HashSet<>();

        ListNode curr1 = l1;
        while (curr1 != null) {
            setMatching.add(curr1);
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;
        while (curr2 != null) {
            if (setMatching.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }

    // Using List Length
    public ListNode getIntersectionNode2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;

        int l1length = length(l1);
        int l2length = length(l2);

        if (l1length < l2length) {
            int distance = l2length - l1length;
            while (distance > 0) {
                l2 = l2.next;
                distance--;
            }
        } else {
            int distance = l1length - l2length;
            while (distance > 0) {
                l1 = l1.next;
                distance--;
            }
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2)
                return l1;
        }

        return null;
    }
}