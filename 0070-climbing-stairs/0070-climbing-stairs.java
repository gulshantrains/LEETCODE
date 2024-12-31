class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int step, int[] dp) {
        if (step == 0)
            return 1;
        if (step < 0)
            return 0;

        if (dp[step] != -1)
            return dp[step];

        int oneStep = solve(step - 1,dp);
        int twoStep = solve(step - 2,dp);

        return dp[step] = oneStep + twoStep;

    }
}