// Runtime: 9 ms, faster than 9.08% of Java online submissions for Generate Parentheses.
// Memory Usage: 39 MB, less than 77.94% of Java online submissions for Generate Parentheses.
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        
        Set<String> set = new HashSet();
        for (int i = 1; i < (n/2+1); i++) {
            List<String> l1 = generateParenåçthesis(i);
            List<String> l2 = generateParenthesis(n-i);
            
            if (i == 1) {
                set.addAll(surround(l2));
            }
            set.addAll(combination(l1, l2));
            set.addAll(combination(l2, l1));
        }
        
        return new ArrayList<>(set);
    }
    
    private List<String> combination(List<String> l1, List<String> l2) {
        List<String> ret = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                ret.add(s1 + s2);
            }
        }
        return ret;
    }

    private List<String> surround(List<String> list) {
        return list.stream().map(l -> "(" + l + ")").collect(Collectors.toList());
    }
}