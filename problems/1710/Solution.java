// Runtime: 7 ms, faster than 90.12% of Java online submissions for Maximum Units on a Truck.
// Memory Usage: 38.7 MB, less than 96.79% of Java online submissions for Maximum Units on a Truck.
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);

        int ret = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int[] box = boxTypes[i];
            if (truckSize <= box[0]) {
                ret += truckSize * box[1];
                break;
            }
            ret += box[0] * box[1];
            truckSize -= box[0];
        }
        return ret;
    }
}