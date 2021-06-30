// Runtime: 9 ms, faster than 100.00% of Java online submissions for Design HashSet.
// Memory Usage: 47.8 MB, less than 27.98% of Java online submissions for Design HashSet.
class MyHashSet {
    boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.arr = new boolean[1000001];
    }
    
    public void add(int key) {
        this.arr[key] = true;
    }
    
    public void remove(int key) {
        this.arr[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return this.arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */