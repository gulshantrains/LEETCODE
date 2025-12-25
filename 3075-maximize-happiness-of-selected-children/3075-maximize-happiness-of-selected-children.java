class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        long ans = 0, cur = 0;
        Arrays.sort(hap);
        int n = hap.length;
        int i = n - 1;

        while (k-- > 0) {
            long rem = hap[i--] - cur;

            if (rem >= 0)
                ans += rem;
            cur++;
        }

        return ans;
    }
}