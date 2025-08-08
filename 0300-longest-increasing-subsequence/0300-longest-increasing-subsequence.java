/*-------------My Mistakes:
I was Not able to thought of add +1 if i take a number
I was passing direct value as previous which was very wrong during Memoization
*/
class Solution {
    int[][] dp;
    int n;

    public int lengthOfLIS(int[] A) {
        n = A.length;
        dp = new int[n + 1][n + 1]; // dp[idx][prev+1]
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(A, 0, -1);
    }

    public int solve(int[] A, int idx, int prev) {
        if (idx == n)
            return 0;

        // Shift prev by +1 so that -1 maps to 0
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        // Case 1: skip current element
        int skip = solve(A, idx + 1, prev);

        // Case 2: take current element (if allowed)
        int take = 0;
        if (prev == -1 || A[prev] < A[idx]) {
            take = 1 + solve(A, idx + 1, idx);
        }

        return dp[idx][prev + 1] = Math.max(skip, take);
    }
}
