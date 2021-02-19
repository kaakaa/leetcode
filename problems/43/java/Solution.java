// Runtime: 927 ms, faster than 5.04% of Java online submissions for Multiply Strings.
// Memory Usage: 40.3 MB, less than 5.28% of Java online submissions for Multiply Strings.
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) {
            return "0";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            char prod = num2.charAt(i);
            String sum = multiply(num1, prod) + new String(new char[num2.length() - 1 - i]).replace('\0', '0');
            // System.out.println(num1 + " + " + prod + " = " + sum);
            temp.add(sum);
        }
        return add(temp);
    }

    private String multiply(String num1, char c) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            char ch = num1.charAt(num1.length() - 1 - i);
            int n = (ch - '0') * (c - '0');
            temp.add(Integer.toString(n) + new String(new char[i]).replace('\0', '0'));
        }
        return add(temp);
    }

    private String add(List<String> list) {
        String ret = "0";
        for (String s : list) {
            ret = add(ret, s);
            // System.out.println(" " + ret + ":" + s);
        }
        return ret;
    }

    private String add(String s1, String s2) {
        String ret = "";
        int maxLen = Math.max(s1.length(), s2.length());
        s1 = String.format("%" + maxLen + "s", s1).replace(' ', '0');
        s2 = String.format("%" + maxLen + "s", s2).replace(' ', '0');

        boolean up = false;
        for (int i = maxLen - 1; i >= 0; i--) {
            int j = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + (up ? 1 : 0);
            // System.out.println(" " + s1.charAt(i) + " + " + s2.charAt(i) + " = " + j);

            if (j >= 10) {
                ret = Integer.toString(j - 10) + ret;
                up = true;
            } else {
                ret = Integer.toString(j) + ret;
                up = false;
            }
        }
        if (up) {
            ret = "1" + ret;
        }
        return ret;
    }
}