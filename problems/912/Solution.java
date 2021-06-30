// Runtime: 189 ms, faster than 26.60% of Java online submissions for Sort an Array.
// Memory Usage: 118.5 MB, less than 5.04% of Java online submissions for Sort an Array.
class Solution {
    public int[] sortArray(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(Arrays.asList(nums[i]));
        }

        while (list.size() > 1) {
            List<List<Integer>> next = new ArrayList<>();
            for (int i = 0; i < list.size(); i+=2) {
                if (i == list.size()-1) {
                    next.add(list.get(i));
                    continue;
                }

                List<Integer> l = new ArrayList<>();
                List<Integer> l1 = list.get(i);
                List<Integer> l2 = list.get(i+1);
                int j = 0, k = 0;
                while (l.size() < l1.size() + l2.size()) {
                    if (j >= l1.size()) {
                        l.add(l2.get(k++));
                        continue;
                    }
                    if (k >= l2.size()) {
                        l.add(l1.get(j++));
                        continue;
                    }
                    l.add(l1.get(j) < l2.get(k) ? l1.get(j++) : l2.get(k++));
                }
                next.add(l);
            }
            list = next;
        }
        return list.get(0).stream().mapToInt(i->i).toArray();
    }
}