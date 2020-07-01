package LinkedList;

public class Add2Integer {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        ListNode dummyHead = new ListNode(0);
        ListNode newPtr = dummyHead;

        int carry = 0;

        while (ptr1 != null || ptr2 != null) {
            int l1Val = (ptr1 != null) ? ptr1.val : 0;
            int l2Val = (ptr2 != null) ? ptr2.val : 0;

            int sum = l1Val + l2Val + carry;

            carry = sum / 10;

            newPtr.next = new ListNode(sum % 10);

            if (ptr1 != null)
                ptr1 = ptr1.next;
            if (ptr2 != null)
                ptr2 = ptr2.next;

            newPtr = newPtr.next;
        }

        if (carry != 0)
            newPtr.next = new ListNode(carry);

        return dummyHead.next;
    }
}