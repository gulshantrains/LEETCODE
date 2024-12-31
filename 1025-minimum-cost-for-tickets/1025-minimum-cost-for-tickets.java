class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int last_day = days[n - 1];
        boolean[] toTravel = new boolean[last_day + 1];
        for (int x : days) {
            toTravel[x] = true;
        }
        int[] dp = new int[last_day + 1];

        dp[0] = 0;
        for (int i = 1; i <= last_day; i++) {
            if (!toTravel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int oneDay = costs[0] + dp[Math.max(i - 1, 0)];
            int sevenDay = costs[1] + dp[Math.max(i - 7, 0)];
            int thirtyDay = costs[2] + dp[Math.max(i - 30, 0)];

            dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return dp[last_day];

    }
}