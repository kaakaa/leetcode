// Runtime: 2 ms, faster than 39.91% of Java online submissions for Decode String.
// Memory Usage: 37.8 MB, less than 13.70% of Java online submissions for Decode String.
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                combine(stack);
            } else {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }
    
    private void combine(Stack<Character> stack) {
        List<Character> temp = new ArrayList<>();
        int times = 0;
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '[') {
                List<Character> timesList = new ArrayList<>();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    timesList.add(stack.pop());
                }
                StringBuilder builder = new StringBuilder();
                for (int i = timesList.size()-1; i >= 0; i--) {
                    builder.append(timesList.get(i));
                }
                times = Integer.valueOf(builder.toString());
                break;
            }
            temp.add(ch);
        }
        int len = temp.size();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < len; j++) {
                stack.push(temp.get(len - 1 - j));
            }
        }
    }
}