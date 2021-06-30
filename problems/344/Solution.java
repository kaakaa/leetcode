// Runtime: 1 ms, faster than 94.44% of Java online submissions for Reverse String.
// Memory Usage: 47.7 MB, less than 6.83% of Java online submissions for Reverse String.
class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
    
    private void reverse(char[] s, int i, int j) {
        if (i >= j) {
            return;
        }
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
        reverse(s, i+1, j-1);
    }
}