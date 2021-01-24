// Runtime: 13 ms, faster than 32.22% of Java online submissions for ZigZag Conversion.
// Memory Usage: 40.1 MB, less than 27.57% of Java online submissions for ZigZag Conversion.
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        Map<Integer, LinkedList<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new LinkedList<>());
        }

        int index = 0;
        boolean asc = true;
        for (int i = 0; i < s.length(); i++) {
            map.get(index).offer(s.charAt(i));

            if (numRows > 1) {
                if (asc) {
                    index++;
                } else {
                    index--;
                }
                if (index == 0 || index == numRows - 1) {
                    asc = !asc;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            LinkedList<Character> chars = map.get(i);
            while (chars.peek() != null) {
                builder.append(chars.pop());
            }
        }
        return builder.toString();
    }
}