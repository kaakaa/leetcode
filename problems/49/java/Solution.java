// Runtime: 39 ms, faster than 9.73% of Java online submissions for Group Anagrams.
// Memory Usage: 59.4 MB, less than 5.11% of Java online submissions for Group Anagrams.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[(int) ('z' - 'a' + 1)];
            for (char ch : s.toCharArray()) {
                int i = (int) (ch - 'a');
                arr[i] = arr[i] + 1;
            }
            String key = Arrays.toString(arr);
            ret.putIfAbsent(key, new ArrayList<>());
            ret.get(key).add(s);
        }
        return new ArrayList(ret.values());
    }
}