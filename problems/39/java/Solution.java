// Runtime: 19 ms, faster than 8.14% of Java online submissions for Combination Sum.
// Memory Usage: 40 MB, less than 23.09% of Java online submissions for Combination Sum.
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumWithReserved(candidates, target, new int[0]);
    }

    private List<List<Integer>> combinationSumWithReserved(int[] candidates, int target, int[] reserved) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] > target) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> list = Arrays.stream(reserved).boxed().collect(Collectors.toList());
                list.add(candidates[i]);
                ret.add(list);
                continue;
            }

            if ((target % candidates[i]) == 0) {
                List<Integer> list = Arrays.stream(reserved).boxed().collect(Collectors.toList());
                list.addAll(Collections.nCopies(target / candidates[i], candidates[i]));
                ret.add(list);
            }

            int subTarget = target - candidates[i];
            List<Integer> subReserved = Arrays.stream(reserved).boxed().collect(Collectors.toList());
            while (subTarget > 0) {
                subReserved.add(candidates[i]);
                // System.out.println(" " + Arrays.toString(Arrays.copyOfRange(candidates, 0,
                // i)) + ":" + subTarget + ":" + Arrays.toString(reserved));
                ret.addAll(combinationSumWithReserved(Arrays.copyOfRange(candidates, 0, i), subTarget,
                        subReserved.stream().mapToInt(n -> n).toArray()));
                subTarget -= candidates[i];
            }
        }
        return ret;
    }
}