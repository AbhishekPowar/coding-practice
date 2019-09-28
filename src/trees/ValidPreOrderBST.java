package trees;

import java.util.Stack;

/**
 *
 * @link <a>https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/</a>
 * 1) Create an empty stack.
 * 2) Initialize root as INT_MIN.
 * 3) Do following for every element pre[i]
 *      a) If pre[i] is smaller than current root, return false.
 *      b) Keep removing elements from stack while pre[i] is greater
 *         then stack top. Make the last removed item as new root (to
 *         be compared next).
 *         At this point, pre[i] is greater than the removed root
 *         (That is why if we see a smaller element in step a), we
 *         return false)
 *      c) push pre[i] to stack (All elements in stack are in decreasing
 *         order)
 */
public class ValidPreOrderBST {
    public boolean isValidBST(int[] pre) {
        Stack<Integer> stack = new Stack<>();


        int root = Integer.MIN_VALUE;


        for(int i=0; i<pre.length; i++) {
            if(pre[i] < root)
                return false;

            while(!stack.isEmpty() && stack.peek() < pre[i]){
                root = stack.peek();
                stack.pop();
            }

            stack.push(pre[i]);
        }

        return true;
    }
    public static void main(String[] args) {
        int[] pre = {2,4,1};

        System.out.println(new ValidPreOrderBST().isValidBST(pre));
    }
}
