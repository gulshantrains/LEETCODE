class Solution {
    private static final int MOD = 1000000007;
    public int[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new int[n+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(n, x, 1);
    }

    private int solve(int remaining, int x, int base) {
        // Base case: found a valid combination
        if (remaining == 0)
            return 1;

        // Base case: no more valid numbers
        if (Math.pow(base, x) > remaining)
            return 0;

        int power = (int) Math.pow(base, x);

        if (dp[remaining][base] != -1)
            return dp[remaining][base];

        // Skip current number
        int skip = solve(remaining, x, base + 1);

        // Take current number
        int take = solve(remaining - power, x, base + 1);

        // Add ways from both branches, take modulo
        return dp[remaining][base] = (skip + take) % MOD;
    }
}
