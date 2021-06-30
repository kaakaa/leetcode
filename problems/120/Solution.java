// Runtime: 2 ms, faster than 76.39% of Java online submissions for Triangle.
// Memory Usage: 39.2 MB, less than 50.61% of Java online submissions for Triangle.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> before = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            before = add(triangle.get(i), before);
        }
        return before.stream().min(Comparator.naturalOrder()).get();
    }

    private List<Integer> add(List<Integer> list, List<Integer> before) {
        for (int i = 0; i < list.size(); i++) {
            int n1 = Integer.MAX_VALUE;
            int n2 = Integer.MAX_VALUE;

            if (i - 1 >= 0) {
                n1 = before.get(i - 1) + list.get(i);
            }
            if (i < before.size()) {
                n2 = before.get(i) + list.get(i);
            }
            int n = n1 < n2 ? n1 : n2;
            list.set(i, n);
        }
        return list;
    }
}