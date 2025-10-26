class Solution {
    public long maxAlternatingSum(int[] A) {
        long ans = 0;
        int n = A.length, half = n / 2;

        for (int i = 0; i < n; i++) {
            A[i] = Math.abs(A[i]);
        }
        
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            long val = (long) A[i] * A[i];

            ans += (i < half ? -val : val);
        }

        return ans;
    }
}