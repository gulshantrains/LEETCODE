class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
/*
Memoization
private int[] dp;

    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }

    public int solve(int n) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = solve(n - 1) + solve(n - 2);
    }
*/