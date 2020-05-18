package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] p_count = new int[26];
        int p_len = p.length();
        int s_len = s.length();

        if(p_len > s_len)
            return Collections.emptyList();
        for(int i=0;i<p.length(); i++) {
            p_count[p.charAt(i)-'a']++;
        }

        int[] s_count = new int[26];
        for(int i=0; i<p_len-1; i++)
            s_count[s.charAt(i)-'a']++;

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length()-p.length()+1; i++)  {
            s_count[s.charAt(i+p_len-1)-'a']++;
            if(i>0)
                s_count[s.charAt(i-1) - 'a']--;
            if(match(s_count, p_count))
                ans.add(i);
        }
        return ans;
    }

    private boolean match(int[] a, int[] b) {
        for(int i=0; i<26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
}
