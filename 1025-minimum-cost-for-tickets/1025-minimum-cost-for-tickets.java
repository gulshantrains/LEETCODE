class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(days, costs, n, 0, dp);
    }

    public int solve(int[] days, int[] cost, int n, int i, int[] dp) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int day1 = cost[0] + solve(days, cost, n, i + 1, dp);

        int j = i;
        int max_days = days[i] + 7;
        while (j < n && days[j] < max_days)
            j++;

        int days7 = cost[1] + solve(days, cost, n, j, dp);

        j = i;
        max_days = days[i] + 30;
        while (j < n && days[j] < max_days)
            j++;

        int days30 = cost[2] + solve(days, cost, n, j, dp);

        dp[i] = Math.min(day1, Math.min(days7, days30));
        return dp[i];

    }
}