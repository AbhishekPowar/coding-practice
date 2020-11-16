package string;

/**
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    private int maxLen = 0;
    private int start = 0;

    /**
     * Runtime: O(N^2)
     * @param str String to search
     * @return Longest Palindromic Substring
     */
    public String find(String str) {
        for(int i=0; i<str.length(); i++) {
            solve(str, i, i);
            solve(str, i, i+1);
        }

        return str.substring(start, start+maxLen);
    }

    private void solve(String str, int L, int R) {
        while(L >=0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }

        int len = R - L - 1;

        if(len > maxLen) {
            maxLen = len;
            start = L + 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().find("babad"));
        System.out.println(new LongestPalindromicSubstring().find("cbbd"));
    }
}
