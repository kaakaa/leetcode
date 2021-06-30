// Runtime: 2 ms, faster than 94.15% of Java online submissions for Valid Anagram.
// Memory Usage: 39.1 MB, less than 59.11% of Java online submissions for Valid Anagram.
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}