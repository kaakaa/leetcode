// Runtime: 146 ms, faster than 26.28% of Java online submissions for Number of Matching Subsequences.
// Memory Usage: 48.2 MB, less than 22.25% of Java online submissions for Number of Matching Subsequences.
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i < 26; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i=0; i < s.length(); i++) {
            int ch = (int)(s.charAt(i) - 'a');
            map.get(ch).add(i);
        }
        
        int ret = 0;
        for (String str : words) {
            int start = -1;
            boolean found = false;
            for (int i = 0; i < str.length(); i++) {
                int ch = (int)(str.charAt(i) - 'a');
                found = false;
                for (Integer idx : map.get(ch)) {
                    if (start < idx) {
                        start = idx;
                        found = true;
                        break;
                    }
                }
                if (!found) break;
            }
            if (found) ret++;
        }
        return ret;
    }
}