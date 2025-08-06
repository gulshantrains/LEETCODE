class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            //We steal the i'th house so choose the max value till i-2 index 
            //...because i-1 is invalid as it is Adjacent
            int rob = nums[i - 1] + dp[i - 2];
            int notRob = dp[i - 1];

            dp[i] = Math.max(rob, notRob);
        }
        return dp[n];
    }
}
/*
int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(nums, n, 0);
    }

    public int solve(int[] nums, int len, int idx) {
        if (idx >= len)
            return 0;

        if (dp[idx] != -1) {
            return dp[idx];
        }
        int take = nums[idx] + solve(nums, len, idx + 2);
        int notTake = solve(nums, len, idx + 1);

        return dp[idx] = Math.max(take, notTake);
    }
---------------------------------------------------------
public int rob(int[] nums) {
        int n = nums.length;

        return solve(nums, n, 0);
    }

    public int solve(int[] nums, int len, int idx) {

        if (idx >= len)
            return 0;

        int take = nums[idx] + solve(nums, len, idx + 2);
        int notTake = solve(nums, len, idx + 1);

        return Math.max(take, notTake);
    }
*/
