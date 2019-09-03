package leetcode;

import java.util.Arrays;

public class CompareString_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] wordFreq = new int[words.length];

        for(int i=0; i<words.length; i++) {
            int wFreq = getMinFreq(words[i]);
            wordFreq[i] = wFreq;
        }
        int[] answ = new int[queries.length];
        int j = 0;
        for(String  query: queries) {
            int freq = getMinFreq(query);
            int c = 0;

            for(int i=0; i<wordFreq.length; i++) {
                if(freq < wordFreq[i])
                    c++;
            }
            answ[j] = c;
            j++;
        }
        return answ;
    }


    private int getMinFreq(String query) {

        int[] freq =  new int[26];
        Arrays.fill(freq, 0);
        for(int i=0; i<query.length(); i++) {
            freq[query.charAt(i) - 'a'] += 1;
        }

        int minFreq = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(freq[i] != 0) {
                minFreq = freq[i];
                break;
            }
        }
        return minFreq;
    }

    public static void main(String[] args) {
        String[] q = {"bbb", "cc"};
        String[] w = {"a", "aa", "aaa", "aaaa"};
        System.out.println(new CompareString_1170().numSmallerByFrequency(q, w));
    }
}
