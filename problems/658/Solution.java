// Runtime: 3 ms, faster than 96.80% of Java online submissions for Find K Closest Elements.
// Memory Usage: 40.6 MB, less than 66.39% of Java online submissions for Find K Closest Elements.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0, right = len-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (mid == left) break;
            if (arr[mid] < x) {
                left = mid;
            } else if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
                right = mid;
                break;
            }
        }
        
        if (Math.abs(arr[left]-x) > Math.abs(arr[right]-x)) {
            left = right;
        } else {
            right = left;
        }
        
        for (int i = 1; i < k; i++) {
            // System.out.println(left + ":" + right);
            if (left == 0) {
                right++;
                continue;
            }
            if (right == len-1) {
                left--;
                continue;
            }
            if (Math.abs(arr[left-1]-x) > Math.abs(arr[right+1]-x)) {
                right++;
            } else {
                left--;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
}