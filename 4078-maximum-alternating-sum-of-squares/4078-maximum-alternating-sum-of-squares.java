class Solution {
    public long maxAlternatingSum(int[] A) {
        long ans = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            A[i] = Math.abs(A[i]);
        }
        Arrays.sort(A);

        for (int i = 0; i < n / 2; i++) {
            ans -= (A[i] * A[i]);
        }
        for (int i = n / 2; i < n; i++) {
            ans += (A[i] * A[i]);
        }

        return ans;
    }
}