// Runtime: 98 ms, faster than 5.13% of Java online submissions for Design Add and Search Words Data Structure.
// Memory Usage: 86.1 MB, less than 5.01% of Java online submissions for Design Add and Search Words Data Structure.
class WordDictionary {
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
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        // System.out.println("SEARCH: " + word);
        return searchWord(word, 0, Arrays.asList(this.root));
    }

    private boolean searchWord(String word, int num, List<TrieNode> nodes) {
        List<TrieNode> next = new ArrayList<>();

        char ch = word.charAt(num);
        switch (ch) {
        case '.':
            for (int i = 0; i < R; i++) {
                for (TrieNode node : nodes) {
                    if (node.containsKey((char) ('a' + i))) {
                        next.add(node.get((char) ('a' + i)));
                    }
                }
            }
            break;
        default:
            for (TrieNode node : nodes) {
                if (node.containsKey(ch)) {
                    next.add(node.get(ch));
                }
            }
        }
        // System.out.println(" " + num + ":" + next.size());
        if (next.size() == 0) {
            return false;
        }
        if (num == word.length() - 1) {
            for (TrieNode node : next) {
                if (node.isEnd()) {
                    return true;
                }
            }
            return false;
        }
        return searchWord(word, num + 1, next);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */