package trie;

public class TrieNode {
    private int MAX_CHARS = 26;
    private TrieNode[] nodes = new TrieNode[MAX_CHARS];

    private boolean completeWord;

    TrieNode() {
        completeWord = false;
        for(int i=0; i<MAX_CHARS; i++) {
            nodes[i] = null;
        }
    }
    public TrieNode getChild(char c) {
        return nodes[c - 'a' < 0 ? c-'A': c - 'a'];
    }
    public void setChild(char c) {
        nodes[c - 'a' < 0 ? c-'A': c - 'a'] =  new TrieNode();
    }
    public boolean isEnd() {
        return completeWord;
    }
    public void setEnd() {
        completeWord = true;
    }
}
