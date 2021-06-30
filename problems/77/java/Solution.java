// Runtime: 20 ms, faster than 46.81% of Java online submissions for Combinations.
// Memory Usage: 39.8 MB, less than 98.13% of Java online submissions for Combinations.
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        internal(ret, nums, n, k, 1);
        return ret;
    }

    private void internal(List<List<Integer>> res, List<Integer> nums, int n, int k, int start) {
        if (nums.size() == k) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i <= n; i++) {
            nums.add(i);
            internal(res, nums, n, k, i + 1);
            nums.remove(nums.size() - 1);
        }
    }
}