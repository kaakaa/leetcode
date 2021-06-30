// Runtime: 1122 ms, faster than 5.98% of Java online submissions for Permutation Sequence.
// Memory Usage: 71.1 MB, less than 5.13% of Java online submissions for Permutation Sequence.
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        permutation(stack, list, builder, 0, k);
        return stack.pop();
    }

    private boolean permutation(Stack<String> stack, List<Integer> list, StringBuilder builder, int count, int k) {
        if (list.size() == 0) {
            stack.push(builder.toString());
            return stack.size() == k;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.remove(i);
            builder.append(num);
            if (permutation(stack, list, builder, count, k)) {
                return true;
            }

            builder.deleteCharAt(builder.length() - 1);

            if (list.size() == 0) {
                list.add(num);
            } else {
                list.add(i, num);
            }
        }
        return false;
    }
}