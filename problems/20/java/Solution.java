// Runtime: 2 ms, faster than 27.19% of Java online submissions for Valid Parentheses.
// Memory Usage: 38.4 MB, less than 15.05% of Java online submissions for Valid Parentheses.
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(', '{', '[':
                    queue.offerLast(s.charAt(i));
                    break;
                case ')':
                    if (queue.size()  == 0 || queue.pollLast().charValue() != '(') 
                        return false;
                    break;
                case '}':
                    if (queue.size()  == 0 || queue.pollLast().charValue() != '{') 
                        return false;
                    break;
                case ']':
                    if (queue.size()  == 0 || queue.pollLast().charValue() != '[') 
                        return false;
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return queue.size() == 0;
    }
}