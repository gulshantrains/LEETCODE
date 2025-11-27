class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long[] pre = new long[n];
        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int start = 0; start < k; start++) {
            long curSum = 0;
            int i = start;

            while (i < n && (i + k - 1) < n) {
                int j = i + k - 1;

                long sum = pre[j] - (i == 0 ? 0L : pre[i - 1]);

                curSum = Math.max(sum, curSum + sum);

                ans = Math.max(curSum, ans);

                i += k;
            }
        }

        return ans;
    }
}