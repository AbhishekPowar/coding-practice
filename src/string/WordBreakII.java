package string;

import java.util.*;

public class WordBreakII {
    HashSet<String> wordMap = new HashSet<>();
    String s = null;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {

        this.s = s;
        int n = s.length();

        this.wordMap.addAll(wordDict);

        StringBuilder currWord = new StringBuilder();
        List<String> solution = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            currWord.append(s.charAt(i));

            if(wordMap.contains(currWord.toString())) {
                currWord.append(" ");
                StringBuilder sentence = new StringBuilder();
                sentence.append(currWord);
                helper(i+1, n, sentence);
                solution.add(sentence.toString().trim());
            }
        }
        return solution;
    }

    protected void helper(int idx, int n, StringBuilder sentence) {

        if(idx >= n)
            return ;
        StringBuilder currWord = new StringBuilder();

        for(int i=idx; i<n; i++) {
            currWord.append(s.charAt(i));
            if(wordMap.contains(currWord.toString())) {
                currWord.append(" ");
                sentence.append(currWord);
                helper(i+1, n, sentence);
                currWord.deleteCharAt(i+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
