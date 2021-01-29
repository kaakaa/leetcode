// Runtime: 24 ms, faster than 8.47% of Java online submissions for 3Sum Closest.
// Memory Usage: 39.1 MB, less than 21.76% of Java online submissions for 3Sum Closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);

        int ret = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                int diff = target - sum;
                if (minDiff > Math.abs(diff)) {
                    minDiff = Math.abs(diff);
                    ret = sum;
                }

                if (diff < 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ret;
    }
}