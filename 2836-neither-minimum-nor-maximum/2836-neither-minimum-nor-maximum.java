class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length == 2 || nums.length == 1)
            return -1;

        int maxidx = max(nums);
        int minidx = min(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != maxidx && i != minidx)
                return nums[i];
        }
        return -1;
    }

    public int max(int[] nums) {
        int maxx = nums[0];
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxx) {
                maxx = nums[1];
                idx = i;
            }
        }
        return idx;
    }

    public int min(int[] nums) {
        int minn = nums[0];
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minn) {
                minn = nums[1];
                idx = i;
            }
        }
        return idx;
    }
}