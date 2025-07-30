class Solution {

    // Recursive function with memoization to count the number of subsets 
    public int countSubset(int idx, int[] nums, int[][] dp, int maxOr, int currOr) {
        int n = nums.length;

        // Base case: if we've considered all elements
        if (idx == n) {
            // If current OR value equals max OR, count this subset
            return currOr == maxOr ? 1 : 0;
        }

        // If we've already computed this state, return the saved result
        if (dp[idx][currOr] != -1) {
            return dp[idx][currOr];
        }

        // Option 1: Include the current element in the subset
        int take = countSubset(idx + 1, nums, dp, maxOr, nums[idx] | currOr);

        // Option 2: Exclude the current element from the subset
        int noTake = countSubset(idx + 1, nums, dp, maxOr, currOr);

        // Store the result in DP table and return the total count
        return dp[idx][currOr] = take + noTake;
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        // First, calculate the maximum OR value possible from all elements
        int maxOr = 0;
        for (int x : nums)
            maxOr |= x;

        // Create a DP table to store intermediate results
        // dp[i][or] means: number of ways to get OR value `or` starting from index `i`
        int[][] dp = new int[n + 1][maxOr + 1];
        for (var x : dp)
            Arrays.fill(x, -1);

        // Start the recursive search from index 0 and OR value 0
        return countSubset(0, nums, dp, maxOr, 0);
    }
}
