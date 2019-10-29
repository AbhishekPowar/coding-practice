package string;

import java.util.*;

public class LongestChain {
    public static int longestChain(List<String> words) {
        Collections.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> memo = new HashMap<>();

        int answer =  0;

        for(String word: words) {
            int best = 0;

            for(int i=0; i<word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i+1);
                best = Math.max(best, memo.getOrDefault(prev, 0)+1);
            }
            memo.put(word, best);
            answer = Math.max(answer, best);
        }
        return answer;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("ba");
        words.add("b");
        words.add("a");;
        words.add("bca");
        words.add("bdca");

        System.out.println(longestChain(words));
    }
}
