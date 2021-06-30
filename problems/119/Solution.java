// Runtime: 4 ms, faster than 5.75% of Java online submissions for Pascal's Triangle II.
// Memory Usage: 36.9 MB, less than 38.94% of Java online submissions for Pascal's Triangle II.
class Solution {
    public List<Integer> getRow(int numRows) {
        if (numRows == 0) {
            return Arrays.asList(1);
        }
        if (numRows == 1) {
            return Arrays.asList(1, 1);
        }
        return recursive(Arrays.asList(1, 1), 2, numRows);
    }

    private List<Integer> recursive(List<Integer> before, int row, int numRows) {
        int[] arr = new int[row];
        arr[0] = 1;
        arr[row - 1] = 1;

        for (int i = 1; i < row - 1; i++) {
            arr[i] = before.get(i - 1) + before.get(i);
        }
        before = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (row - 1 == numRows) {
            return before;
        }
        return recursive(before, row + 1, numRows);
    }
}
