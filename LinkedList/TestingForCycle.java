package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class TestingForCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        Set<ListNode> seen = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if (seen.contains(curr)) {
                return true;
            }
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }
}