// Runtime: 51 ms, faster than 10.69% of Java online submissions for Min Stack.
// Memory Usage: 40.6 MB, less than 60.34% of Java online submissions for Min Stack.
class MinStack {
    private int[] arr;
    private int n;

    /** initialize your data structure here. */
    public MinStack() {
        this.arr = new int[128];
        this.n = 0;
    }

    public void push(int val) {
        if (n >= arr.length - 1) {
            this.arr = Arrays.copyOf(this.arr, arr.length * 2);
        }
        this.arr[n++] = val;
    }

    public void pop() {
        n--;
        if (n < arr.length / 2) {
            this.arr = Arrays.copyOf(this.arr, arr.length / 2);
        }
    }

    public int top() {
        return this.arr[n - 1];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */