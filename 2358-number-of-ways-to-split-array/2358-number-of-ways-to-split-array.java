class Solution {
    public int waysToSplitArray(int[] nums) {
        int cnt = 0;
        long tSum = 0;
        long[] presum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tSum += nums[i];
            if (i == 0)
                presum[i] = nums[i];
            else
                presum[i] = presum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (presum[i] >= tSum - presum[i]) {
                cnt++;
            }
        }
        return cnt;

    }
}