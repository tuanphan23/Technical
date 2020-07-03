package LinkedList;

public class RightShiftASinglyLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }

        k %= size;

        if (k == 0)
            return head;

        tail.next = head;
        ListNode newTail = tail;
        for (int i = 0; i < size - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}