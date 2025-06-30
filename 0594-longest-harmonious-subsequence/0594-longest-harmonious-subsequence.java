class Solution {
    public int findLHS(int[] A) {
        int n = A.length;
        int ans = 0;

        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (A[j] == A[i] + 1) {
                    ans = Math.max(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }
}