// Runtime: 21 ms, faster than 30.83% of Java online submissions for 4Sum.
// Memory Usage: 39.4 MB, less than 78.55% of Java online submissions for 4Sum.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        if (nums.length < 4) {
            return new ArrayList<>(ret);
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    // System.out.println(i + ":" + j + ":" + k + ":" + l);
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                    } else if (sum < target) {
                        int old = nums[k];
                        do {
                            k++;
                        } while(old == nums[k] && k < l);
                        
                    } else if (sum > target) {
                        int old = nums[l];
                        do {
                            l--;
                        } while(old == nums[l] && k < l);
                    }
                }
            }
        }
        return new ArrayList<>(ret);
    }
}