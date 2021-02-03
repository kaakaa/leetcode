// Runtime: 5 ms, faster than 94.75% of Java online submissions for Merge Intervals.
// Memory Usage: 42.1 MB, less than 23.71% of Java online submissions for Merge Intervals.
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if (i1[0] == i2[0]) {
                    return i1[1] - i2[1];
                }
                return i1[0] - i2[0];
            }
        });
        
        int[][] tmp = new int[intervals.length][2];
        tmp[0] = intervals[0];
        int index = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] target = intervals[i];
            if (target[0] <= tmp[index-1][1]) {
                int[] prev = tmp[index-1];
                if (target[1] > prev[1]) {
                    prev[1] = target[1];
                    tmp[index-1] = prev;
                }
            } else {
                tmp[index] = target;
                index++;
            }
        }
        
        return Arrays.copyOfRange(tmp, 0, index);
    }
}