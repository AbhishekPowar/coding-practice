package string;

import java.util.Arrays;

public class ContainsPermutation_567 {
    public boolean checkInclusion(String s1, String s2) {


        if(s2.length() < s1.length())
            return false;

        int[] freqCount = new int[26];

        Arrays.fill(freqCount, 0);

        int count = s1.length();
        for(int i=0; i<s1.length(); i++) {
            freqCount[s1.charAt(i) - 'a'] += 1;
        }

        int sub[] = new int[26];
        Arrays.fill(sub, 0);

        for(int i=0; i<s1.length(); i++)
            sub[s2.charAt(i) - 'a'] += 1;

        int j=0;
        while(j < s2.length() - s1.length() +1) {
            boolean found = true;
            for(int i=0; i<26; i++) {
                if(freqCount[i] != sub[i]) {
                    found = false;
                    break;
                }
            }

            if(!found) {
                sub[s2.charAt(j) - 'a'] -= 1;
            } else {
                return true;
            }
            j++;

            if(j < s2.length() - s1.length() +1)
                sub[s2.charAt(j-1+s1.length()) - 'a'] += 1;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";

        String s2 = "eidbaooo";

        System.out.println(new ContainsPermutation_567().checkInclusion(s1, s2));
    }
}
