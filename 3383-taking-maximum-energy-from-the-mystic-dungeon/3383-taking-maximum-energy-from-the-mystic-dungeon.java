class Solution {
    public int maximumEnergy(int[] ene, int k) {
        int ans = -2147483648, n = ene.length;
        int[] dp = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = (ene[i] + (i + k < n ? dp[i + k] : 0));

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}