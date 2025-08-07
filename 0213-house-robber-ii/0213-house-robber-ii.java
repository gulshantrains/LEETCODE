class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Case 1: Exclude last house, rob from 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int rob1 = robFrom(nums, 0, n - 2, dp1);

        // Case 2: Exclude first house, rob from 1 to n-1
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int rob2 = robFrom(nums, 1, n - 1, dp2);

        return Math.max(rob1, rob2);
    }

    private int robFrom(int[] nums, int idx, int end, int[] dp) {
        if (idx > end)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int take = nums[idx] + robFrom(nums, idx + 2, end, dp);
        int skip = robFrom(nums, idx + 1, end, dp);

        return dp[idx] = Math.max(take, skip);
    }
}
