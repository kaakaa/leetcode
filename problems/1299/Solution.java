// Runtime: 1 ms, faster than 99.95% of Java online submissions for Replace Elements with Greatest Element on Right Side.
// Memory Usage: 39.7 MB, less than 97.25% of Java online submissions for Replace Elements with Greatest Element on Right Side.
class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }
        return arr;
    }
}