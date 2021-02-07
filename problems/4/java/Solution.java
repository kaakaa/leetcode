// Runtime: 5 ms, faster than 21.65% of Java online submissions for Median of Two Sorted Arrays.
// Memory Usage: 46.7 MB, less than 10.62% of Java online submissions for Median of Two Sorted Arrays.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean isEven = false;
        if ((m + n) % 2 == 0) {
            isEven = true;
        }
        
        int cur = 0, prev = 0;
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i == m) {
                cur = nums2[j];
                j++;
            } else if (j == n) {
                cur = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
            
            if (isEven) {
                if ((i + j - 1) == (m + n) / 2) {
                    return (prev + (double)cur) / 2;
                }
            } else {
                if ((i + j - 1) == Math.floor((m + n) / 2)) {
                    return (double)cur;
                }
            }
            
            prev = cur;
        }
        throw new RuntimeException();
    }
}