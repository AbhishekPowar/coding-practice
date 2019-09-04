package leetcode;

import java.util.HashMap;

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

    private HashMap<String, Integer> cache = new HashMap<>();
    private String s1;
    private String s2;

    public int minDistance(String word1, String word2) {
        s1 = word1;
        s2 = word2;

        return lev(s1.length(), s2.length());
    }

    private int lev(int i,  int j) {
        if(i == 0  || j ==0) {
            cache.put(i+","+j, Math.max(i,j));
            return Math.max(i,j);
        }

        if(cache.containsKey(i+","+j))
            return cache.get(i+","+j);

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            cache.put(i+","+j, lev(i-1, j-1));
            return lev(i-1, j-1);
        }
        cache.put(i+","+j,Math.min(1+lev(i-1,j), Math.min(1+lev(i,j-1), 1+lev(i-1,j-1))));

        return cache.get(i+","+j);

    }

    public static void main(String[] args) {
        String s1 = "dinitrophenylhydrazine";
        String s2 = "acetylphenylhydrazine";

        System.out.println(new EditDistance_72().minDistance(s1, s2));
    }
}
