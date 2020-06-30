package LinkedList;

public class DesignALinkedList {
    public class LinkedList {
        ListNode head;
        int size;

        public int get(int index) {
            if (index < 0 || index >= this.size) {
                return -1;
            }

            ListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node.val;
        }

        public void addToHead(int value) {
            ListNode node = new ListNode(value);

            node.next = head.next;
            head.next = node;
            size++;
        }

        public void addToTail(int value) {
            ListNode node = new ListNode(value);
            ListNode curr = head;
            for (int i = 0; i < size; i++) {
                curr = curr.next;
            }
            curr.next = node;
            size++;
        }

        public void addAtIndex(int index, int value) {
            if (index < 0 || index >= this.size) {
                return;
            }

            ListNode node = new ListNode(value);
            ListNode curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.size)
                return;

            ListNode curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
            size--;
        }

        private class ListNode {
            int val;
            ListNode next;

            public ListNode() {
            }

            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}