// Runtime: 4 ms, faster than 96.74% of Java online submissions for Design Circular Queue.
// Memory Usage: 39.7 MB, less than 22.10% of Java online submissions for Design Circular Queue.
class MyCircularQueue {
    private int[] data;
    private int size;
    private int start, end;
    private boolean isFull;

    public MyCircularQueue(int k) {
        this.size = k;
        this.data = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.data[i] = -1;
        }
        this.start = 0;
        this.end = 0;
        this.isFull = false;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        this.data[this.end] = value;
        this.end = this.end == this.size - 1 ? 0 : this.end + 1;
        if (this.start == this.end) {
            this.isFull = true;
        }
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }

        this.data[this.start] = -1;
        this.start = this.start == this.size - 1 ? 0 : this.start + 1;
        this.isFull = false;
        return true;
    }

    public int Front() {
        return this.data[this.start];
    }

    public int Rear() {
        int idx = this.end - 1 == -1 ? this.size - 1 : this.end - 1;
        return this.data[idx];
    }

    public boolean isEmpty() {
        return !this.isFull() && (this.start == this.end);
    }

    public boolean isFull() {
        return this.isFull;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */