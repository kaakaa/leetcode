// Runtime: 64 ms, faster than 16.97% of Java online submissions for Ugly Number II.
// Memory Usage: 38.7 MB, less than 19.28% of Java online submissions for Ugly Number II.

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        n--;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1 * 2);
        set.add(1 * 3);
        set.add(1 * 5);

        while (true) {
            n--;
            int first = set.pollFirst();
            if (n == 0) {
                System.out.println(set.size());
                System.out.println(set);
                return first;
            }
            add(set, first, 2);
            add(set, first, 3);
            add(set, first, 5);
        }
    }

    private void add(Set<Integer> set, int min, int num) {
        if (min > Integer.MAX_VALUE / num) {
            return;
        }
        int n = min * num;
        if (n > 0)
            set.add(n);
    }
}