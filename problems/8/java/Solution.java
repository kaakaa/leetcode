// Runtime: 6 ms, faster than 14.94% of Java online submissions for String to Integer (atoi).
// Memory Usage: 38.6 MB, less than 95.77% of Java online submissions for String to Integer (atoi).
class Solution {
    public int myAtoi(String s) {
        boolean neg = false;
        boolean digit = false;
        boolean ignore = false;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!digit) {
                switch (s.charAt(i)) {
                    case ' ':
                        break;
                    case '+', '-':
                        digit = true;
                        neg = s.charAt(i) == '-' ? true : false;
                        break;
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                        digit = true;
                        builder.append(s.charAt(i));
                        break;
                    default:
                        ignore = true;
                        break;
                }
            } else {
                switch (s.charAt(i)) {
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                        builder.append(s.charAt(i));
                        break;
                    default:
                        ignore = true;
                        break;
                }
            }
            if (ignore) {
                break;
            }
        }

        System.out.println(builder.toString());
        int rev = 0;
        for (int i = 0; i < builder.length(); i++) {
            int pop = Character.getNumericValue(builder.charAt(i));
            if (neg) {
                if (rev > (-1 * (Integer.MIN_VALUE / 10)) || (rev == (-1 * (Integer.MIN_VALUE / 10)) && pop > 8))
                    return Integer.MIN_VALUE;
            } else {
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                    return Integer.MAX_VALUE;
            }
            rev = rev * 10 + pop;
        }
        if (neg) {
            return -1 * rev;
        }
        return rev;
    }
}