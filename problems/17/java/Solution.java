// Runtime: 1 ms, faster than 80.62% of Java online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 37.5 MB, less than 93.88% of Java online submissions for Letter Combinations of a Phone Number.

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<Character[]> chars = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            chars.add(numToCharArray(digits.charAt(i)));
        }

        List<String> ret = Stream.of(chars.get(0)).map(c -> c.toString()).collect(Collectors.toList());
        if (chars.size() == 1) {
            return ret;
        }

        for (int i = 1; i < chars.size(); i++) {
            List<String> newRet = new ArrayList<>();
            for (String str : ret) {
                for (Character ch : chars.get(i)) {
                    newRet.add(str + ch.toString());
                }
            }
            ret = newRet;
        }
        return ret;
    }

    private Character[] numToCharArray(char num) {
        switch (num) {
            case '2':
                return new Character[] { 'a', 'b', 'c' };
            case '3':
                return new Character[] { 'd', 'e', 'f' };
            case '4':
                return new Character[] { 'g', 'h', 'i' };
            case '5':
                return new Character[] { 'j', 'k', 'l' };
            case '6':
                return new Character[] { 'm', 'n', 'o' };
            case '7':
                return new Character[] { 'p', 'q', 'r', 's' };
            case '8':
                return new Character[] { 't', 'u', 'v' };
            case '9':
                return new Character[] { 'w', 'x', 'y', 'z' };
            default:
                throw new RuntimeException();
        }
    }
}