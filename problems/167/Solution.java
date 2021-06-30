// Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
// Memory Usage: 39.7 MB, less than 15.97% of Java online submissions for Two Sum II - Input array is sorted.
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = len-1; i > 0; i--) {
            int n = numbers[i];
            if (target < n) continue;
            
            int left = 0, right = i-1;
            while (left <= right) {
                int mid = left + (right-left)/2;
                int m = n + numbers[mid];
                
                if (m == target) return new int[]{mid+1, i+1};
                if (m < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return new int[]{1, 2};
    }
}