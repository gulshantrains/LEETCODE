class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start the recursive function from the first day (index 0)
        return solve(days, costs, n, 0, dp);
    }

    public int solve(int[] days, int[] cost, int n, int i, int[] dp) {
        // Base case: If the index goes beyond the number of travel days, the cost is 0
        if (i >= n)
            return 0;

        // If we have already computed the minimum cost for this day, return it
        if (dp[i] != -1)
            return dp[i];

        // Option 1: Buy a 1-day pass and move to the next day
        int day1 = cost[0] + solve(days, cost, n, i + 1, dp);

        // Option 2: Buy a 7-day pass
        // Find the first day after `days[i] + 7` (inclusive)
        int j = i;
        int max_days = days[i] + 7;
        while (j < n && days[j] < max_days)
            j++;
        int days7 = cost[1] + solve(days, cost, n, j, dp);

        // Option 3: Buy a 30-day pass
        // Find the first day after `days[i] + 30` (inclusive)
        j = i;
        max_days = days[i] + 30;
        while (j < n && days[j] < max_days)
            j++;
        int days30 = cost[2] + solve(days, cost, n, j, dp);

        // Store the minimum cost among the three options in the dp array
        dp[i] = Math.min(day1, Math.min(days7, days30));
        return dp[i];
    }
}
