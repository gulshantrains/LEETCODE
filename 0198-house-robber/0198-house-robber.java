class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case: No house to rob
        if (n == 0) return 0;

        // dp[i] will represent the max money that can be robbed from the first i houses
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;           // Robbing 0 houses = 0 money
        dp[1] = nums[0];     // Only one house to rob

        for (int i = 2; i <= n; i++) {
            // Option 1: Rob current house (i-1), so skip the previous (i-2)
            int rob = nums[i - 1] + dp[i - 2];

            // Option 2: Don't rob current house, carry forward the previous max
            int notRob = dp[i - 1];

            // Choose the better of the two options
            dp[i] = Math.max(rob, notRob);
        }

        // dp[n] contains the answer for all houses
        return dp[n];
    }
}
/*
class Solution {
    int[] dp; // Memoization array

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1); // Fill with -1 to denote uncomputed states

        return solve(nums, n, 0); // Start from index 0
    }

    // Recursive function to find max money from idx to end
    public int solve(int[] nums, int len, int idx) {
        // Base case: No house to rob
        if (idx >= len)
            return 0;

        // If already computed, return the result
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Option 1: Rob current house → add its value + solve from idx+2
        int take = nums[idx] + solve(nums, len, idx + 2);

        // Option 2: Skip current house → solve from next house
        int notTake = solve(nums, len, idx + 1);

        // Store and return the maximum of both choices
        return dp[idx] = Math.max(take, notTake);
    }
}
--------------------------------------------------------------------
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Start recursive exploration from index 0
        return solve(nums, n, 0);
    }

    public int solve(int[] nums, int len, int idx) {
        // Base case: No house to rob
        if (idx >= len)
            return 0;

        // Option 1: Rob current house → move to idx + 2
        int take = nums[idx] + solve(nums, len, idx + 2);

        // Option 2: Skip current house → move to idx + 1
        int notTake = solve(nums, len, idx + 1);

        // Return the better of the two options
        return Math.max(take, notTake);
    }
}

*/