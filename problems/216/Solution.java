// Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
// Memory Usage: 36.4 MB, less than 67.46% of Java online submissions for Combination Sum III.
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            find(k, n, i, new ArrayList<>(), ret);
        }
        return ret;
    }

    private void find(int k, int n, int i, List<Integer> list, List<List<Integer>> ret) {
        // System.out.println(k + ":" + n + ":" + i + "/" + list);
        if ((n - i) == 0 && (k - 1) == 0) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            ret.add(temp);
            return;
        }

        list.add(i);
        k--;
        int o = n - i;
        for (int j = i + 1; j <= Math.min(n, 9); j++) {
            find(k, o, j, list, ret);
        }
        list.remove(list.size() - 1);
        return;
    }
}