// Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
// Memory Usage: 39.3 MB, less than 26.43% of Java online submissions for Longest Valid Parentheses.
class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> queue = new LinkedList<>();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    queue.offerLast(i);
                    break;
                case ')':
                    if (queue.size() == 0) {
                        continue;
                    }
                    if (ret < (i - queue.peekLast() + 1)) {
                        ret = i - queue.peekLast() + 1;
                    }
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == '(') {
                            i++;
                        } else {
                            queue.pollLast();
                        }
                    }
                    break;
                default:
                    throw new RuntimeException("invalid charactor");
            }
        }
        return ret;
    }
}