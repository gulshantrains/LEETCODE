class Solution {
    long[][] dp = new long[100001][2];

    public long solve(int[] nums, int start, boolean flag) {
        if (start >= nums.length)
            return 0;
        int f = (flag ? 1 : 0);

        if (dp[start][f] != -1)
            return dp[start][f];

        long noTake = solve(nums, start + 1, flag);
        long take = (flag == true ? nums[start] : -nums[start]) + solve(nums, start + 1, !flag);

        return dp[start][f] = Math.max(take, noTake);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (var x : dp)
            Arrays.fill(x, -1);

        return solve(nums, 0, true);
    }
}