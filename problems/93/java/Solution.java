// Runtime: 1 ms, faster than 98.71% of Java online submissions for Restore IP Addresses.
// Memory Usage: 39.4 MB, less than 44.48% of Java online submissions for Restore IP Addresses.
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int seg = 4;
        List<String> ret = new ArrayList<>();
        String temp = "";
        backtracking(ret, temp, s, seg);
        return ret;
    }

    private void backtracking(List<String> ret, String temp, String s, int seg) {
        int len = s.length();
        if (len == 0 && seg == 0) {
            ret.add(temp);
            return;
        }
        if (len > seg * 3) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (len < i) {
                break;
            }

            String d = s.substring(0, i);
            if (i != 1 && d.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(d) > 255) {
                continue;
            }
            if (!temp.isEmpty()) {
                d = new StringBuilder(temp).append(".").append(d).toString();
            }

            backtracking(ret, d, s.substring(i), seg - 1);
        }
        return;
    }
}