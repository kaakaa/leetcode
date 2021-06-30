// Runtime: 8 ms, faster than 6.92% of Java online submissions for Permutations.
// Memory Usage: 43.1 MB, less than 5.20% of Java online submissions for Permutations.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            List<List<Integer>> tmp = new ArrayList<>();
            tmp.add(l);
            List<Integer> rest = Arrays.stream(nums).boxed().collect(Collectors.toList());
            rest.remove(i);
            ret.addAll(add(tmp, rest));
        }
        return ret;
    }
    
    private List<List<Integer>> add(List<List<Integer>> base, List<Integer> rest) {
        if (rest.size() == 0) {
            return base;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (List<Integer> l : base) {
            for (Integer i : rest) {
                List<Integer> copy = clone(l);
                copy.add(i);
                List<List<Integer>> tmp = new ArrayList<>();
                tmp.add(copy);
                List<Integer> copyRest = clone(rest);
                copyRest.remove(i);
                ret.addAll(add(tmp, copyRest));
            }
        }
        return ret;
    }
    
    private List<Integer> clone(List<Integer> list) {
        return new ArrayList(list);
    }
}