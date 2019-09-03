package leetcode;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {

        return helper(word1, word2, 0, 0);
    }

    private int helper(String w1, String w2, int  i, int j) {

        if(i == w1.length()) {
            return w2.length() - j;
        }
        if(j==w2.length()) {
            return w1.length() - i;
        }
        if(w1.charAt(i) == w2.charAt(j)) {
            return helper(w1, w2, i+1, j+1);
        }
        //delete a  character
        int deleteBranch = 1 + helper(w1, w2, i+1, j);
        int replaceBranch = 1 + helper(w1, w2, i+1, j+1);
        int addBranch = 1 + helper(w1, w2, i, j+1);

        return Math.min(deleteBranch, Math.min(replaceBranch, addBranch));

    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println(new EditDistance_72().minDistance(s1, s2));
    }
}
