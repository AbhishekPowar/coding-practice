package linkedlists;

import java.util.Stack;

public class DetectYShape {

    /**
     * Two Stack Approach
     * Time Complexity: O(n)
     * Space Complexity: O(m+n), where m and n are length of respective lists
     * @param node1
     * @param node2
     * @return
     */
    public ListNode detectY(ListNode node1, ListNode node2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode n1 = node1;
        while(n1 != null) {
            s1.push(n1);
            n1 = n1.next;
        }
        ListNode n2 = node2;
        while(n2 != null) {
            s2.push(n2);
            n2 = n2.next;
        }

        n1 = null;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(s1.peek().val != s2.peek().val)
                return n1;
            n1 = s1.peek();
            s1.pop();
            s2.pop();
        }
        return n1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param head1 Head of first list
     * @param head2 Head of second list
     * @return Node where both list converge
     */
    public <T extends Comparable<T>> ListNode<T> detectYApproach2(ListNode<T> head1, ListNode<T> head2) {
        int len1 = length(head1);
        int len2 = length(head2);

        int diff = (len1 > len2) ? len1-len2 : len2-len1;

        ListNode<T> curr1, curr2;
        // List 1 has more elements
        if(len1 > len2) {
            curr1 = head1;
            curr2 = head2;
        }
        else {  // List 2 has more elements
            curr1 = head2;
            curr2 = head1;
        }

        int i = 0;
        // skip to node difference of both list
        while(i < diff) {
            curr1 = curr1.next;
            i++;
        }
        while(curr1 != null && curr2 != null) {
            if(curr1.val == curr2.val)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    /**
     * Two pointer approach
     * @param headA
     * @param headB
     * @return
     */
    public ListNode detectYApproach3(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while(a != b) {
            a = (a==null) ? headB:a.next;
            b = (b==null) ? headA:b.next;
        }
        return a;
    }

    private int length(ListNode node) {
        int count = 0;

        ListNode curr = node;

        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return  count;
    }

    public static <T extends Comparable<T>> ListNode<T> overLappingListsWithCycle(ListNode<T> l1, ListNode<T> l2) {
        ListNode<T> headA = DetectCycle.hasCycle(l1);
        ListNode<T> headB = DetectCycle.hasCycle(l2);

        if(headA == null && headB == null) {
            // detect with no cycles
        } else if((headA != null && headB == null) || (headA == null && headB != null))
            return null;
        else {

        }
        return null;
    }
    public static void main(String[] args) {
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        ListNode<Integer> n3 = new ListNode<>(3);
        ListNode<Integer> n4 = new ListNode<>(4);
        ListNode<Integer> n5 = new ListNode<>(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n2;

       ListNode<Integer> node = new DetectYShape().detectYApproach2(n1, n5);
        System.out.println(node == null ? node: node.val);
    }
}
