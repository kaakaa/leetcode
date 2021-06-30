// Runtime: 14 ms, faster than 5.88% of Java online submissions for Subsets II.
// Memory Usage: 38.9 MB, less than 97.48% of Java online submissions for Subsets II.
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ret.add(new ArrayList<>(temp));

        recursive(ret, temp, 0, nums);
        return ret;
    }

    private void recursive(List<List<Integer>> ret, List<Integer> temp, int k, int[] nums) {
        for (int i = k; i < nums.length; i++) {
            temp.add(nums[i]);
            List<Integer> l = new ArrayList<>(temp);
            Collections.sort(l);
            if (!ret.contains(l)) {
                ret.add(l);
            }
            recursive(ret, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}