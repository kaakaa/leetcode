// Runtime: 1 ms, faster than 59.78% of Java online submissions for Longest Common Prefix.
// Memory Usage: 37.3 MB, less than 50.65% of Java online submissions for Longest Common Prefix.
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        char[] chars = strs[0].toCharArray();
        int l = chars.length;
        for (int i = 1; i < strs.length; i++) {
            if (l > strs[i].length()) {
                l = strs[i].length();
            }
            char[] tmp = new char[l];
            boolean b = false;
            for (int j = 0; j < l; j++) {
                if (chars[j] != strs[i].charAt(j)) {
                    break;
                }
                b = true;
                tmp[j] = chars[j];
            }
            if (!b) {
                return "";
            }
            chars = tmp;
        }
        return new String(chars).replace("\0", "");
    }
}