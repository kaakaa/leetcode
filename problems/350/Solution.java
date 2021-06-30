// Runtime: 4 ms, faster than 27.71% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39.1 MB, less than 63.41% of Java online submissions for Intersection of Two Arrays II.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int i1 = 0;
        int i2 = 0;
        
        List<Integer> ret = new ArrayList<>();
        while (i1 < l1 && i2 < l2) {
            int n1 = nums1[i1], n2 = nums2[i2];
            if (n1 == n2) {
                ret.add(nums1[i1]);
                i1++; i2++;
            } else if (n1 < n2) {
                i1++;
            } else if (n1 > n2) {
                i2++;
            }
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
}