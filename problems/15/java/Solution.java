// Runtime: 178 ms, faster than 33.63% of Java online submissions for 3Sum.
// Memory Usage: 44.7 MB, less than 16.35% of Java online submissions for 3Sum.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<Integer> sorted = IntStream.of(nums).boxed().collect(Collectors.toList());
        Collections.sort(sorted);

        Map<String, List<Integer>> ret = new HashMap<>();
        if (3 <= sorted.stream().filter(i -> i == 0).count()) {
            ret.put("0,0,0", Arrays.asList(0, 0, 0));
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (sorted.get(i) >= 0) {
                break;
            }
            if (i > 0 && sorted.get(i - 1) == sorted.get(i)) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int x = sorted.get(i) + sorted.get(j) + sorted.get(k);
                if (x == 0) {
                    List<Integer> l = Arrays.asList(sorted.get(i), sorted.get(j), sorted.get(k));
                    Collections.sort(l);
                    ret.putIfAbsent(toKey(l), l);
                    j++;
                } else if (x < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ret.values().stream().collect(Collectors.toList());
    }

    private String toKey(List<Integer> list) {
        return String.format("%d,%d,%d", list.get(0), list.get(1), list.get(2));
    }
}