// Runtime: 17 ms, faster than 98.44% of Java online submissions for Stone Game VII.
// Memory Usage: 38.2 MB, less than 99.22% of Java online submissions for Stone Game VII.
// refs: https://dev.to/seanpgallivan/solution-stone-game-vii-3lei
class Solution {
    int alice = 0;
    int bob = 0;
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[] cur = new int[len];
        int[] last = new int[len];
        for (int i = len-2; i >= 0; i--) {
            int total = stones[i];
            int[] temp = last;
            last = cur;
            cur = temp;
            for (int j=i+1; j < len; j++) {
                total += stones[j];
                cur[j] = Math.max(total-stones[i]-last[j],total-stones[j]-cur[j-1]);
            }
        }
        return cur[len-1];
    }
}