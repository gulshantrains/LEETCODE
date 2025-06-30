class Solution {
    public static int mod = (int) 1e9 + 7;

    public int numSubseq(int[] A, int target) {
        Arrays.sort(A);
        int l = 0, n = A.length, r = n - 1;
        int ans = 0;

        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (pows[i - 1] * 2) % mod;
        }

        while (l <= r) {
            if (A[l] + A[r] <= target) {
                int temp = pows[r - l] % mod;
                ans = (ans + temp) % mod;

                l++;
            } else
                r--;
        }
        return  ans;
    }
}