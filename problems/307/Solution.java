// Runtime: 92 ms, faster than 51.48% of Java online submissions for Range Sum Query - Mutable.
// Memory Usage: 70.8 MB, less than 36.24% of Java online submissions for Range Sum Query - Mutable.
class NumArray {
    private int len;
    private int[] tree;

    public NumArray(int[] nums) {
        this.len = nums.length;
        this.tree = new int[2 * len];

        for (int i = 0; i < len; i++) {
            this.tree[i + len] = nums[i];
        }
        for (int i = len - 1; i > 0; --i) {
            this.tree[i] = this.tree[2 * i] + this.tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        int pos = index + len;
        this.tree[pos] = val;
        while (pos > 0) {
            int l = pos;
            int r = pos;
            if (pos % 2 == 0) {
                r++;
            } else {
                l--;
            }
            pos /= 2;
            this.tree[pos] = this.tree[l] + this.tree[r];
        }
    }

    public int sumRange(int left, int right) {
        int l = left + len;
        int r = right + len;
        int sum = 0;
        while (l <= r) {
            if (l % 2 == 1) {
                sum += this.tree[l];
                l++;
            }
            if (r % 2 == 0) {
                sum += this.tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(index,val); int param_2 =
 * obj.sumRange(left,right);
 */