// Runtime: 18 ms, faster than 15.39% of Java online submissions for Basic Calculator II.
// Memory Usage: 40.7 MB, less than 20.77% of Java online submissions for Basic Calculator II.
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        List<Integer> list = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        int len = s.length();
        int idx = 0;
        while (idx < len && (0 <= s.charAt(idx) - '0' && s.charAt(idx) - '0' <= 9)) {
            builder.append(s.charAt(idx++));
        }

        list.add(Integer.valueOf(builder.toString()));
        builder.delete(0, builder.length() - 1);

        for (int i = idx; i < len; i++) {
            char ch = s.charAt(i);
            String num = "";
            switch (ch) {
            case '+':
                num = readNumber(s, ++i);
                list.add(Integer.valueOf(num));
                break;
            case '-':
                num = readNumber(s, ++i);
                list.add(-1 * Integer.valueOf(num));
                break;
            case '*':
                num = readNumber(s, ++i);
                list.add(list.remove(list.size() - 1) * Integer.valueOf(num));
                break;
            case '/':
                num = readNumber(s, ++i);
                list.add(list.remove(list.size() - 1) / Integer.valueOf(num));
                break;
            default:
            }
            i += num.length() - 1;
        }
        int ret = 0;
        for (Integer i : list) {
            ret += i;
        }
        return ret;
    }

    private String readNumber(String s, int i) {
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        while (i < len && (0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9)) {
            builder.append(s.charAt(i++));
        }
        return builder.toString();
    }
}