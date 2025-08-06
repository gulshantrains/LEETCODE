class Solution {
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
}
/*
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
