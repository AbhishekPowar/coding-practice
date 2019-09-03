package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveConsZero_1171 {

      public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
      }
    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode currNode = head;

        int runningSum =  0;

        while(currNode != null) {
            if(runningSum == 0) {
                runningSum = currNode.val < 0 ? currNode.val:0;

                if(runningSum == 0) {
                    currNode =  currNode.next;
                    stack.push(currNode);
                }

            } else if(runningSum < 0) {
                ListNode node = stack.pop();
                runningSum = node.val - runningSum;
                currNode = currNode.next;
            }
        }
        ListNode h = null;
        for(ListNode node: stack)  {
            node.next = h;
            h = node;
        }
        return h;
    }

    public static void main(String[] args) {
    }
}
