class Solution {
    public int minCost(String co, int[] nT) {
        int n = nT.length;

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (co.charAt(i) == co.charAt(i - 1)) {
                ans += Math.min(nT[i], nT[i - 1]);

                if (nT[i] < nT[i - 1]) {
                    nT[i] = nT[i - 1];
                }
            }

        }

        return ans;

    }
}