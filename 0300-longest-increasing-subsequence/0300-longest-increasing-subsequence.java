/*-------------My Mistakes:
I was Not able to thought of add +1 if i take a number
I was passing direct value as previous which was very wrong during Memoization
*/
class Solution {
    int[][] dp = new int[2501][2501];

    public int lengthOfLIS(int[] A) {
        int n = A.length;
        if (n == 1)
            return 1;
        for (var x : dp)
            Arrays.fill(x, -1);

        return solve(A, 0, -1);
    }

    public int solve(int[] A, int idx, int prev) {
        if (idx >= A.length)
            return 0;

        if (prev != -1 && dp[idx][prev] != -1)
            return dp[idx][prev];

        //Case 1: Not Take
        int skip = solve(A, idx + 1, prev);

        //Case 2: Take But Only if Last Choosen Element Should be Less than Curr
        int take = 0;
        if (prev == -1 || A[prev] < A[idx]) {
            take = 1 + solve(A, idx + 1, idx);

        }
        if (prev != -1)
            dp[idx][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }
}