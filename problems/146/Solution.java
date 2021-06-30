// Runtime: 12 ms, faster than 98.56% of Java online submissions for LRU Cache.
// Memory Usage: 47 MB, less than 69.50% of Java online submissions for LRU Cache.
class LRUCache {
    private float DEFAULT_LOAD_FACTOR = 0.75f;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */