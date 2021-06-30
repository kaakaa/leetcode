// Runtime: 327 ms, faster than 5.07% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 47.4 MB, less than 97.90% of Java online submissions for Implement Trie (Prefix Tree).
class Trie {
    private Set<String> set;

    /** Initialize your data structure here. */
    public Trie() {
        this.set = new TreeSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        this.set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.set.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return this.set.stream().filter(s -> s.startsWith(prefix)).findAny().isPresent();
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */