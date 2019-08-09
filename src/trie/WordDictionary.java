package trie;

public class WordDictionary {
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currNode = root;

        for(int i=0; i<word.length(); i++) {
            if(currNode.getChild(word.charAt(i)) == null) {
                currNode.setChild(word.charAt(i));
            }
            currNode = currNode.getChild(word.charAt(i));
        }
        currNode.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWithExpression(word, root);
    }

    private boolean searchWithExpression(String word, TrieNode currNode) {

        int i = 0;
        while(i < word.length()) {
            // if current character is ".", then we need to search every other character for current prefix
            if(word.charAt(i) == '.') {
                TrieNode temp = currNode;
                for(int j=0; j<26; j++) {
                    if(temp.getChild((char)('a'+j)) != null) {
                        // return true only if we recursively found the solution
                        if(searchWithExpression(word.substring(i+1), temp.getChild((char)('a'+j))))
                            return true;
                    }
                }
                return false;
            } else {
                if(currNode.getChild(word.charAt(i)) == null)
                    return false;
                currNode = currNode.getChild(word.charAt(i));
            }
            i++;
        }
        return currNode.isEnd();
    }

    public static void main(String[] args) {
        String[] words = {"dad", "bad", "mad","pad"};
        String[] queries = {".ad", "b..", "b"};

        WordDictionary dictionary = new WordDictionary();
        for(String word: words)
            dictionary.addWord(word);

        for (String query: queries)
            System.out.println(dictionary.search(query));
    }
}
