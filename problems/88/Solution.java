// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
// Memory Usage: 39.3 MB, less than 21.86% of Java online submissions for Merge Sorted Array.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) return;
        
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums1[m-1] < nums2[n-1]) {
                nums1[i] = nums2[n-1];
                n--;
            } else {
                nums1[i] = nums1[m-1];
                m--;
            }
            if (m <= 0) {
                for (int j = 0; j < n; j++) {
                    nums1[j] = nums2[j];
                }
                return;
            }
            if (n <= 0) {
                return;
            }
        }
    }
}