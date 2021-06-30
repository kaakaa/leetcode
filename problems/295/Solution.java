// 
class MedianFinder {
    private List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        int s = list.size();
        Integer[] arr = list.toArray(new Integer[s]);
        Arrays.sort(arr);
        if (s % 2 == 0) {
            return ((double) arr[s / 2 - 1] + arr[s / 2]) / 2;
        } else {
            return arr[s / 2];
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */