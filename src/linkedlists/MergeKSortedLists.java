package linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public ListNode mergeKLists_Approach1(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));

        while(true) {
            for(int i=0; i<lists.length; i++)
                if(lists[i] != null) {
                    queue.add(lists[i]);
                    lists[i] = lists[i].next;
                }
            if(queue.isEmpty()) {
                curr.next = null;
                break;
            }
            curr = curr.next = queue.poll();
        }
        return head.next;
    }
}
