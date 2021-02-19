// Runtime: 1991 ms, faster than 5.06% of Java online submissions for Combination Sum II.
// Memory Usage: 40 MB, less than 18.59% of Java online submissions for Combination Sum II.
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> ret = new HashSet<>();
        while (candidates.length != 0) {
            if (candidates[0] > target)
                break;
            if (candidates[0] == target)
                ret.add(new ArrayList<>(Arrays.asList(candidates[0])));

            int num = candidates[0];
            candidates = Arrays.copyOfRange(candidates, 1, candidates.length);
            List<List<Integer>> temp = combinationSum2(candidates, target - num);
            for (List<Integer> l : temp) {
                l.add(0, num);
            }
            ret.addAll(temp);
        }
        return new ArrayList<>(ret);
    }
}