// Runtime: 7 ms, faster than 10.64% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39.6 MB, less than 17.79% of Java online submissions for Intersection of Two Arrays.
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(s::contains).toArray();
    }
}