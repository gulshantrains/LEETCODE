class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k][n]; //K-->Rows(0,1,2,3..k-1) these are module & n column
        for (int[] x : dp)
            Arrays.fill(x, 1);

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;

                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxLength = Math.max(maxLength, dp[mod][i]);
            }
        }
        return maxLength;
    }

}