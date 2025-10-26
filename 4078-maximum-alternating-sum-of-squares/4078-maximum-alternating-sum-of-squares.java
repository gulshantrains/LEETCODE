class Solution {
    public long maxAlternatingSum(int[] x) {
        long ans = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            x[i] = Math.abs(x[i]);
        }
        Arrays.sort(x);

        for (int i = 0; i < n / 2; i++) {
            ans -= (x[i] * x[i]);
        }
        for (int i = n / 2; i < n; i++) {
            ans += (x[i] * x[i]);
        }

        return ans;
    }
}