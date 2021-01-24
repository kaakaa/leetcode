// Runtime: 1338 ms, faster than 5.02% of Java online submissions for Longest Palindromic Substring.
// Memory Usage: 38 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String ret = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            // If `j` starts from `j = i+1`, the result will be Time Lmit Exceeded
            for (int j = s.length() - 1; j > i; j--) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    if (isPalindromic(s, i, j)) {
                        String cand = s.substring(i, j + 1);
                        if (ret.length() < cand.length()) {
                            ret = cand;
                        }
                        break;
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindromic(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}
