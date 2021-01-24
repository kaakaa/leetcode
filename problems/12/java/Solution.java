// Runtime: 9 ms, faster than 28.54% of Java online submissions for Integer to Roman.
// Memory Usage: 43.5 MB, less than 5.28% of Java online submissions for Integer to Roman.
class Solution {
    public String intToRoman(int num) {
        StringBuilder b = new StringBuilder();
        b.append(toRoman(num / 1000, 'M', '\0', '\0'));
        b.append(toRoman((num % 1000) / 100, 'C', 'D', 'M'));
        b.append(toRoman((num % 100) / 10, 'X', 'L', 'C'));
        b.append(toRoman((num % 10), 'I', 'V', 'X'));
        return b.toString();
    }

    private String toRoman(int i, char one, char five, char ten) {
        switch (i) {
            case 1, 2, 3:
                return new String(new char[i]).replace('\0', one);
            case 4:
                return new String(new char[] { one, five });
            case 5:
                return new String(new char[] { five });
            case 6, 7, 8:
                return new String(new char[] { five }) + new String(new char[i - 5]).replace('\0', one);
            case 9:
                return new String(new char[] { one, ten });
            default:
                return "";
        }
    }
}