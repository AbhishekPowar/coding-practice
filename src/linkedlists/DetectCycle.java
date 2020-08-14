package linkedlists;

public class DetectCycle {

    public static boolean detectCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    /**
     * Returns Node where cycle begins
     *
     * Let 'F' be the number of nodes before cycle, and 'C' be number of nodes in cycle
     * 'n' be total number of nodes. Then time complexity is O(F) + O(C) = O(n) - O(F)
     * O(F) + k*O(C)
     * @param node
     * @return
     */
    public static <T extends Comparable<T>> ListNode<T> hasCycle(ListNode<T> node) {
        ListNode<T> slow = node, fast = node;

        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = node;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
