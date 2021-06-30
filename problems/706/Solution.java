// Runtime: 102 ms, faster than 11.24% of Java online submissions for Design HashMap.
// Memory Usage: 47.3 MB, less than 24.63% of Java online submissions for Design HashMap.
class MyHashMap {
    int[] arr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.arr = new int[1000001];
        for (int i = 0; i <= 1000000; i++) {
            this.arr[i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return this.arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */