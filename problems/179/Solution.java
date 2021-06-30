// Runtime: 8 ms, faster than 25.98% of Java online submissions for Largest Number.
// Memory Usage: 38.8 MB, less than 25.13% of Java online submissions for Largest Number.
class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new CustomComparator());
        // System.out.println(Arrays.toString(arr));
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }
        String ret = builder.toString().replaceFirst("^0+(?!$)", "");
        return ret.isEmpty() ? "0" : ret;
    }

    private class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            int m = a.length();
            int n = b.length();
            if (m == n) {
                int ai = Integer.valueOf(a);
                int bi = Integer.valueOf(b);
                if (ai == bi) {
                    return 0;
                } else if (ai > bi) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (m > n) {
                for (int i = 0; i < m; i++) {
                    if (a.charAt(i) > b.charAt(i % n)) {
                        return 1;
                    } else if (a.charAt(i) < b.charAt(i % n)) {
                        return -1;
                    }
                }
                return this.compare(a.substring(n), b);
            } else {
                for (int i = 0; i < n; i++) {
                    if (a.charAt(i % m) > b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i % m) < b.charAt(i)) {
                        return -1;
                    }
                }
                return this.compare(a, b.substring(m));
            }
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
}