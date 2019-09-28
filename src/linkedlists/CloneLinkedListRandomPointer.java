package linkedlists;

import java.util.HashMap;

public class CloneLinkedListRandomPointer {
    private static class ListNode {
        private int val;
        public ListNode next;
        public ListNode random;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param head
     * @return
     */
    public ListNode cloneLL1(ListNode head) {

        HashMap<ListNode, ListNode> clones = new HashMap<>();

        ListNode curr = head;

        while(curr != null) {
            ListNode newNode = new ListNode(curr.val);
            clones.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        ListNode newHead = clones.get(head);

        while (curr!= null) {
            ListNode tmp = clones.get(curr);
            tmp.random = clones.get(curr.random);
            tmp.next = clones.get(curr.next);

            curr = curr.next;
        }

        return newHead;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param head
     * @return
     */
    public ListNode cloneLL2(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;

        while (curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        ListNode newHead = head.next;

        curr = head;
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return newHead;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;
        node5.random = node1;

        ListNode node = new CloneLinkedListRandomPointer().cloneLL2(node1);

        while(node != null) {
            System.out.println(node.val+" random: "+node.random.val);
            node = node.next;
        }
    }
}
