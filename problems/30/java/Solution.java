// Runtime: 2140 ms, faster than 5.02% of Java online submissions for Substring with Concatenation of All Words.
// Memory Usage: 40.2 MB, less than 30.25% of Java online submissions for Substring with Concatenation of All Words.
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int wLen = words[0].length();
        for (int i = 0; i <= s.length() - (wLen * words.length); i++) {
            List<String> wordList = new ArrayList<>(Arrays.asList(words));
            String sub = s.substring(i, i + wLen);
            System.out.println("sub1: " + sub + " (" + i + ")");
            if (contains(wordList, sub)) {
                wordList.remove(sub);
                if (wordList.size() == 0) {
                    ret.add(i);
                    continue;
                }
                if (isConcatenation(wordList, s, i, wLen)) {
                    ret.add(i);
                }
            }
        }
        return ret;
    }

    private boolean contains(List<String> wordList, String str) {
        return wordList.contains(str);
    }

    private boolean isConcatenation(List<String> wordList, String s, int i, int wLen) {
        for (int j = i + wLen; j <= s.length() - wLen; j += wLen) {
            String sub = s.substring(j, j + wLen);
            System.out.println("  sub2: " + sub);
            if (contains(wordList, sub)) {
                wordList.remove(sub);
                if (wordList.size() == 0) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}