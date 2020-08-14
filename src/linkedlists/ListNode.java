package linkedlists;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode<T extends Comparable<T>> {
    public T val;
    public ListNode<T> next;

    public ListNode(T x) {
        this.val = x;
    }
}
