package LinkedList;

public class RemoveKthToLastElement {
    public ListNode removeKthToLastElement(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode right = dummyHead.next;

        while (k > 0) {
            right = right.next;
            k--;
        }

        ListNode left = dummyHead;
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyHead.next;
    }
}