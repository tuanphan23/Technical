package LinkedList;

public class SwapInPairs {
    public ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        head = head.next;
        ListNode newStart = null;

        while (true) {
            newStart = second.next;
            second.next = first.next;

            if (newStart == null || newStart.next == null) {
                first.next = newStart;
                return head;
            }

            first.next = newStart.next;
            first = newStart;
            second = newStart.next;
        }
    }
}