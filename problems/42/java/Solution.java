// Runtime: 11 ms, faster than 9.45% of Java online submissions for Trapping Rain Water.
// Memory Usage: 39.3 MB, less than 19.05% of Java online submissions for Trapping Rain Water.
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int start = findStartPoint(height);
        int end = findEndPoint(height);

        System.out.println(start + ":" + end);
        if (end - start < 2) {
            return 0;
        }

        return count(height, start, end);
    }

    private int count(int[] height, int i, int j) {
        int ret = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (i < j) {
            int h = height[i];
            int k = i + 1;

            int second = 0;
            int secondIndex = 0;
            while (k <= j && h > height[k]) {
                if (second < height[k]) {
                    second = height[k];
                    secondIndex = k;
                }
                list.offerLast(height[k]);
                k++;
            }

            // System.out.println("[" + i + "] " + k + " / " + secondIndex + " : " +
            // list.size());
            // list.forEach(l -> System.out.println(" " + l));

            if (k > j && secondIndex != 0) {
                for (int t = i + 1; t <= secondIndex; t++) {
                    ret += second - list.pollFirst();
                }
                list.clear();
                i = secondIndex;
                continue;
            } else if (list.size() >= 1) {
                while (list.peek() != null) {
                    ret += h - list.pollFirst();
                }
            }
            list.clear();
            i = k;
        }
        return ret;
    }

    private int findStartPoint(int[] height) {
        int h = 0;
        int i = 0;
        while (i < height.length && h <= height[i]) {
            h = height[i];
            i++;
        }
        return --i;
    }

    private int findEndPoint(int[] height) {
        int h = 0;
        int i = height.length - 1;
        while (i >= 0 && h <= height[i]) {
            h = height[i];
            i--;
        }
        return ++i;
    }
}
