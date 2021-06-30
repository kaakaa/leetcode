// Runtime: 21 ms, faster than 7.07% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
// Memory Usage: 58.9 MB, less than 5.25% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
// refs: https://dev.to/seanpgallivan/solution-maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts-45p8
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length-1]);
        for (int i = 1; i < horizontalCuts.length; i++)
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        for (int i = 1; i < verticalCuts.length; i++)
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i-1]);
        
        return (int)((long)maxW * maxH % 1000000007);
    }
}