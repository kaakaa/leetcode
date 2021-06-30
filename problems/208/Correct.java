// Runtime: 33 ms, faster than 48.67% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 48.2 MB, less than 75.45% of Java online submissions for Implement Trie (Prefix Tree).
class Trie {
    private final int R = 26;

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd = false;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.searchWord(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = this.searchWord(prefix);
        return node != null;
    }

    private TrieNode searchWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.get(ch);
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */