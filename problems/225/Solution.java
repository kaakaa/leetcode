// Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
// Memory Usage: 36.7 MB, less than 54.18% of Java online submissions for Implement Stack using Queues.
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.queue1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = this.queue1.size();
        for (int i = 0; i < size-1; i++) {
            this.queue2.offer(this.queue1.poll());
        }
        int x = this.queue1.poll();
        Queue<Integer> temp = this.queue2;
        this.queue2 = this.queue1;
        this.queue1 = temp;
        return x;
    }
    
    /** Get the top element. */
    public int top() {
        int last = -1;
        while (!this.queue1.isEmpty()) {
            last = this.queue1.poll();
            this.queue2.offer(last);
        }
        Queue<Integer> temp = this.queue2;
        this.queue2 = this.queue1;
        this.queue1 = temp;
        return last;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue1.isEmpty() && this.queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */