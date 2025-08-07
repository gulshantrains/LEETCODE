class Solution {
    // dp[i][f]: maximum alternating sum starting from index 'i'
    // where f = 1 means next element will be added (even index in subsequence)
    // and f = 0 means next element will be subtracted (odd index in subsequence)

    long[][] dp = new long[100001][2];

    public long solve(int[] nums, int start, boolean flag) {
        if (start >= nums.length)
            return 0;

        // Convert boolean flag to int index (1 for true, 0 for false)
        int f = (flag ? 1 : 0);

        // If already computed, return memoized value
        if (dp[start][f] != -1)
            return dp[start][f];

        // Option 1: Skip the current element
        long noTake = solve(nums, start + 1, flag);

        // Option 2: Take the current element with alternating sign
        // If flag is true, add the number (even position in subsequence)
        // If false, subtract the number (odd position in subsequence)
        long take = (flag ? nums[start] : -nums[start]) + solve(nums, start + 1, !flag);

        return dp[start][f] = Math.max(take, noTake);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (var x : dp)
            Arrays.fill(x, -1);

        return solve(nums, 0, true);
    }
}
