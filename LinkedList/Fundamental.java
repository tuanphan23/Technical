package LinkedList;

import java.util.Stack;

public class Fundamental {
    // print the linked list
    public void printList(ListNode head) {
        ListNode pointer = head;

        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    // print the linked list recursively
    public void printList(ListNode head) {
        if (head == null)
            return;

        System.out.println(head.value);

        printList(head.next);
    }

    // print the linked list reversely
    public void printReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode pointer = head;

        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }

        while (!stack.isEmptyy()) {
            ListNode node = stack.pop();
            System.out.println(node.value);
        }
    }

    // print the linked list reversely using recursion
    public void printList(ListNode head) {

        if (head == null) {
            return;
        }

        printList(head.next);

        System.out.println(head.value);
    }

    // reverse the linked list
    public ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}