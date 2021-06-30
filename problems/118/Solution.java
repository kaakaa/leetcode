// Runtime: 2 ms, faster than 20.30% of Java online submissions for Pascal's Triangle.
// Memory Usage: 37 MB, less than 51.73% of Java online submissions for Pascal's Triangle.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Arrays.asList(1));
        if (numRows == 1) {
            return ret;
        }
        ret.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return ret;
        }
        recursive(ret, Arrays.asList(1, 1), 3, numRows);
        return ret;
    }

    private void recursive(List<List<Integer>> ret, List<Integer> before, int row, int numRows) {
        int[] arr = new int[row];
        arr[0] = 1;
        arr[row - 1] = 1;

        for (int i = 1; i < row - 1; i++) {
            arr[i] = before.get(i - 1) + before.get(i);
        }
        before = Arrays.stream(arr).boxed().collect(Collectors.toList());
        ret.add(before);
        if (row == numRows) {
            return;
        }
        recursive(ret, before, row + 1, numRows);
    }
}
