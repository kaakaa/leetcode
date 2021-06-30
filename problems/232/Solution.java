// Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
// Memory Usage: 36.7 MB, less than 60.02% of Java online submissions for Implement Queue using Stacks.
class MyQueue {
    private Stack<Integer> filo;
    private Stack<Integer> fifo;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.filo = new Stack<>();
        this.fifo = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (filo.isEmpty() && fifo.isEmpty()) {
            filo.add(x);
        } else if (!filo.isEmpty()) {
            fifo.add(x);
            while(!filo.isEmpty()) {
                fifo.add(filo.pop());
            }
        } else if (!fifo.isEmpty()) {
            while(!fifo.isEmpty()) {
                filo.add(fifo.pop());
            }
            filo.add(x);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!filo.isEmpty()) {
            while(!filo.isEmpty()) {
                fifo.add(filo.pop());
            }
        }
        return fifo.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!filo.isEmpty()) {
            while(!filo.isEmpty()) {
                fifo.add(filo.pop());
            }
        }
        return fifo.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return filo.isEmpty() && fifo.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */