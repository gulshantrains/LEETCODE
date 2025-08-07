class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0]; // Only one house
        if (n == 2)
            return Math.max(nums[0], nums[1]); // Two houses, choose max
 //dp[i]-->Max profit when we have i House
        // Case 1: Include first house, exclude last → nums[0] to nums[n-2]
        int[] dp1 = new int[n + 1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i <= n - 1; i++) {
            int skip = dp1[i - 1];
            int take = nums[i - 1] + dp1[i - 2];
            dp1[i] = Math.max(skip, take);
            //Will store Result in dp[n-1];
        }

        // Case 2: Exclude first house, include last → nums[1] to nums[n-1]
        int[] dp2 = new int[n + 1];
        dp2[1] = 0;
        dp2[2] = nums[1];
        for (int i = 3; i <= n; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i - 1] + dp2[i - 2]);
            //Will store result in dp[n]
        }

        return Math.max(dp1[n - 1], dp2[n]);
    }
}
