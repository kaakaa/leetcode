// Runtime: 3 ms, faster than 98.39% of Java online submissions for Evaluate Reverse Polish Notation.
// Memory Usage: 38.3 MB, less than 92.11% of Java online submissions for Evaluate Reverse Polish Notation.
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            // System.out.println(stack);
            String s = tokens[i];
            switch(s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int prev = stack.pop();
                    stack.push(stack.pop() - prev);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    prev = stack.pop();
                    stack.push(stack.pop() / prev);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}