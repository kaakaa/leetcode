// Runtime: 2 ms, faster than 33.79% of Java online submissions for Reverse Integer.
// Memory Usage: 36.2 MB, less than 43.49% of Java online submissions for Reverse Integer.
class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }

        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        String inv = builder.toString();

        if (isExcess(inv, neg)) {
            return 0;
        }
        Integer ret = Integer.valueOf(inv);
        if (neg) {
            ret = -ret;
        }
        return ret;
    }

    private boolean isExcess(String s, boolean neg) {
        String max;
        if (neg) {
            max = String.valueOf(Integer.MIN_VALUE).substring(1);
        } else {
            max = String.valueOf(Integer.MAX_VALUE);
        }
        if (max.length() > s.length()) {
            return false;
        }
        if (max.length() < s.length()) {
            return true;
        }
        for (int j = 0; j < s.length(); j++) {
            Integer i1 = Integer.valueOf(s.charAt(j));
            Integer i2 = Integer.valueOf(max.charAt(j));
            if (i1 < i2) {
                return false;
            }
            if (i1 > i2) {
                return true;
            }
        }
        return false;
    }
}