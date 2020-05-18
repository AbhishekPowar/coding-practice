package string;

/**
 *
 * Leetcode: https://leetcode.com/problems/permutation-in-string/
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class ContainsPermutation_567 {

    public boolean checkInclusion(String s1, String s2) {
        int s1_len = s1.length();
        int s2_len = s2.length();

        if(s1_len > s2_len)
            return false;

        int[] s1_freq_count = new int[26];

        for(int i=0;i<s1_len; i++)
            s1_freq_count[s1.charAt(i)-'a']++;

        int[] s2_window_freq_count = new int[26];
        for(int i=0; i<s1_len-1; i++)
            s2_window_freq_count[s2.charAt(i)-'a']++;

        for(int i=0; i<s2_len-s1_len+1; i++)  {
            s2_window_freq_count[s2.charAt(i+s1_len-1)-'a']++;
            if(i>0)
                s2_window_freq_count[s2.charAt(i-1) - 'a']--;
            if(match(s2_window_freq_count, s1_freq_count))
                return true;
        }
        return false;
    }

    private boolean match(int[] a, int[] b) {
        for(int i=0; i<26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";

        String s2 = "eidbaooo";

        System.out.println(new ContainsPermutation_567().checkInclusion(s1, s2));
    }
}
