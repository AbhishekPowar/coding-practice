package linkedlists;

public class ReverseLinkedListInPairsK {


    public ListNode reverKGroup(ListNode head, int k) {

        ListNode curr = head;
        int i = 0;
        while(curr != null && i < k) {
            curr = curr.next;
            i++;
        }

        if(i == k) {
            curr = reverKGroup(curr, k);
            while(i-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = new ReverseLinkedListInPairsK().reverKGroup(n1, 3);

        while(node!= null) {
            System.out.print(node.val+"  ");
            node = node.next;
        }

    }
}
