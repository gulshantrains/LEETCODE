class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(suf, 1);

        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            pre[i] = nums[i]*pre[i-1];
        }
        for (int j = n - 2; j >= 0; j--) {
            suf[j] = nums[j]*suf[j+1];
        }
        //Arrays.stream(pre).forEach(System.out::print);
        //Arrays.stream(suf).forEach(System.out::print);
        for (int i = 0; i < n; i++) {
            if (i == 0)
                ans[i] = suf[i + 1];
            else if (i == n - 1)
                ans[i] = pre[n - 2];
            else
                ans[i] = pre[i - 1] * suf[i + 1];
        }
        return ans;
    }
}