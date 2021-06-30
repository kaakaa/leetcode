// Runtime: 1 ms, faster than 79.62% of Java online submissions for Word Pattern.
// Memory Usage: 36.8 MB, less than 78.17% of Java online submissions for Word Pattern.
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch) && !map.get(ch).equals(words[i])) {
                return false;
            }
            map.put(ch, words[i]);
        }
        Set<String> values = new HashSet<>(map.values());
        return map.size() == values.size();
    }
}