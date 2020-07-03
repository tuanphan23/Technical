package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneALinkedList {
    public ListNode clone(ListNode head) {
        if (head == null)
            return head;
        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            map.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}