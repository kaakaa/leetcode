// Runtime: 1892 ms, faster than 5.86% of Java online submissions for Interleaving String.
// Memory Usage: 37.1 MB, less than 79.82% of Java online submissions for Interleaving String.
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return backtrack(s1, s2, s3, 0, 0);
    }
    
    private boolean backtrack(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length() && i + j == s3.length()) {
            return true;
        }
        if (i + j >= s3.length()) return false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (backtrack(s1, s2, s3, i+1, j)) return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (backtrack(s1, s2, s3, i, j+1)) return true;
        }
        return false;
    }
}