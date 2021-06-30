// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
// Memory Usage: 38.9 MB, less than 85.57% of Java online submissions for Find Smallest Letter Greater Than Target.
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int diff = (int)(target - letters[len-1]);
        if (0 <= diff) return letters[0];
        diff = (int)(target - letters[0]);
        if (diff < 0) return letters[0];
        
        int left = 0, right = len-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            diff = (int)(target - letters[mid]);
            if (diff == 0) {
                return nextChar(letters, mid, target);
            }
            if (diff < 0) right = mid-1;
            else left = mid+1;
        }
        return nextChar(letters, left, target);
    }
    
    private char nextChar(char[] letters, int mid, char ch) {
        int len = letters.length;
        while (mid < len - 1 && letters[mid] <= ch) {
            mid++;
        }
        if (mid == len) return letters[0];
        return letters[mid];
    }
}