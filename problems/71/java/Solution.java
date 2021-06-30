// Runtime: 7 ms, faster than 34.70% of Java online submissions for Simplify Path.
// Memory Usage: 39 MB, less than 72.89% of Java online submissions for Simplify Path.
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String p : path.split("/")) {
            switch (p) {
                case "":
                case ".":
                    continue;
                case "..":
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(p);
            }
        }
        return "/" + stack.stream().collect(Collectors.joining("/"));
    }
}