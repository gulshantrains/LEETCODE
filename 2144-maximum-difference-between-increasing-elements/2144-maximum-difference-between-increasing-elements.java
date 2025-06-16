class Solution {
    public int maximumDifference(int[] n) {
        int ans = -1;
        int premin = n[0];

        for (int i = 1; i < n.length; i++) {
            if (n[i] > premin) {
                ans = Math.max(ans, n[i] - premin);
            } else {
                premin = n[i];
            }
        }
        return ans;
    }
}