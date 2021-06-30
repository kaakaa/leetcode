// Runtime: 0 ms, faster than 100.00% of Java online submissions for K-th Symbol in Grammar.
// Memory Usage: 35.5 MB, less than 85.77% of Java online submissions for K-th Symbol in Grammar.
class Solution {
    public int kthGrammar(int n, int k) {
        // L: true, R: false
        Queue<Boolean> queue = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            if (k%2 == 0) {
                queue.offer(false);
            } else {
                queue.offer(true);
            }
            k = (k+1) / 2;
        }
        
        int num = 0;
        while(!queue.isEmpty()) {
            if (queue.poll()) {
                num = num == 0 ? 0 : 1;
            } else {
                num = num == 0 ? 1 : 0;
            }
        }
        return num;
    }
}