class Solution {
    public long getDescentPeriods(int[] prices) {
        long curr = 1, ans = 1, n = prices.length;

        for (int i = 1; i < n; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                curr++;
            } else {
                curr = 1;
            }

            ans += curr;
        }

        return ans;
    }
}