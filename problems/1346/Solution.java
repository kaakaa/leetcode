// Runtime: 1 ms, faster than 99.01% of Java online submissions for Check If N and Its Double Exist.
// Memory Usage: 38.6 MB, less than 57.00% of Java online submissions for Check If N and Its Double Exist.
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int pos = 0;
        while (pos < len && arr[pos] < 0) { pos++; }
        if (pos == len) pos = len - 1;
        if (pos > 1) {
            int fast = pos - 1, slow = pos;
            while (true) {
                int n = arr[slow--];
                while (fast >= 0 && 2 * n < arr[fast]) { fast--; }
                if (fast < 0) break;
                if (2 * n == arr[fast]) return true;
                fast++;
            }
        }
        if (pos == len-1) return false;
        
        int fast = pos+1, slow = pos;
        while (true) {
            int n = arr[slow++];
            while (fast < len && 2 * n > arr[fast]) { fast++; }
            if (fast == len) return false;
            if (2 * n == arr[fast]) return true;
            fast--;
        }
    }
}