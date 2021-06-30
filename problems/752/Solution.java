// Runtime: 150 ms, faster than 44.10% of Java online submissions for Open the Lock.
// Memory Usage: 86.4 MB, less than 5.18% of Java online submissions for Open the Lock.
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> memo = Arrays.stream(deadends).collect(Collectors.toSet());
        if (memo.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList("0000"));
        int step = 0;

        while (!q.isEmpty()) {
            step++;
            for (int i = q.size(); i > 0; i--) {
                StringBuilder builder = new StringBuilder(q.poll());
                for (int j = 0; j < 4; j++) {
                    // System.out.println(step + ":" + builder.toString());
                    char ch1 = builder.charAt(j);

                    builder.setCharAt(j, next(ch1));
                    String word = builder.toString();
                    if (word.equals(target)) {
                        return step;
                    }
                    if (!memo.contains(word)) {
                        memo.add(word);
                        q.offer(word);
                    }

                    builder.setCharAt(j, prev(ch1));
                    word = builder.toString();
                    if (word.equals(target)) {
                        return step;
                    }
                    if (!memo.contains(word)) {
                        memo.add(word);
                        q.offer(word);
                    }
                    builder.setCharAt(j, ch1);
                }
            }
        }
        return -1;
    }

    private char next(char ch) {
        if (ch == '9') {
            return '0';
        }
        return (char) (ch + 1);
    }

    private char prev(char ch) {
        if (ch == '0') {
            return '9';
        }
        return (char) (ch - 1);
    }
}