package trie;

/**
 * mplement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class PrefixTree_Trie_208 {

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode currNode = root;

        for(int i=0; i<word.length(); i++) {
            if(currNode.getChild(word.charAt(i)) == null) {
                currNode.setChild(word.charAt(i));
            }
            currNode = currNode.getChild(word.charAt(i));
        }
        currNode.setEnd();
    }

    private boolean search(String word) {

        TrieNode currNode = root;

        for(int i=0; i<word.length(); i++) {
            if(currNode.getChild(word.charAt(i)) == null)
                return false;
            currNode = currNode.getChild(word.charAt(i));
        }
        return currNode.isEnd();
    }

    private boolean startsWith(String word) {
        return false;
    }

    private boolean searchWithExpression(String word, TrieNode currNode) {

        if(currNode.isEnd())
            return true;

        int i = 0;
        while(i < word.length()) {
            if(word.charAt(i) == '.') {
                TrieNode temp = currNode;
                for(int j=0; j<26; j++) {
                    if(temp.getChild((char)('a'+j)) != null) {
                        return searchWithExpression(word.substring(i+1), temp.getChild((char)('a'+j)));
                    }
                }
            }
            if(currNode.getChild(word.charAt(i)) == null)
                return false;
            currNode = currNode.getChild(word.charAt(i));
            i++;
        }
        return currNode.isEnd();
    }

    public TrieNode getRoot() {
        return root;
    }
    private boolean searchWithExpression(String word, int index, TrieNode node) {

        if(node.getChild(word.charAt(index)) == null)
            return false;
        if(node.isEnd())
            return true;
        if(word.charAt(index) == '.') {
            for(int i=0; i<26; i++) {
                return  searchWithExpression(word, index+1, node.getChild((char)('a' + i)));
            }
        }

        return searchWithExpression(word, index+1, node.getChild(word.charAt(index)));
    }

    public static void main(String[] args) {
        PrefixTree_Trie_208 p = new PrefixTree_Trie_208();

        String[] words = {"WordDictionary","addWord","addWord","search","search","search","search","search","search"};

        for(String word: words)
            p.insert(word);

        String[] queries = {"", "a", "a", ".", "a", "aa", "a", ".a", "a."};

        for (String query: queries)
            System.out.println(p.searchWithExpression(query, p.getRoot() ));
    }
}
