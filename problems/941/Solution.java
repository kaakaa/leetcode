// Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Mountain Array.
// Memory Usage: 39.9 MB, less than 74.93% of Java online submissions for Valid Mountain Array.
class Solution {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) return false;
        
        int i = 0;
        while (i < len-1) {
            if (arr[i] == arr[i+1]) return false;
            if (arr[i] > arr[i+1]) break;
            i++;
        }
        if (i == 0 || i == len-1) return false;
        
        while (i < len-1) {
            if (arr[i] <= arr[i+1]) return false;
            i++;
        }
        return true;
    }
}