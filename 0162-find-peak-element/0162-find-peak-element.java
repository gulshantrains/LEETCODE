class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        boolean[] ans = new boolean[n];
        Arrays.fill(ans, false);

        for (int i = 0; i < n; i++) {
            if (i == 0 && n>1 && nums[i] > nums[i + 1])
                ans[i] = true;
            if (i == n - 1 && n>1 && nums[i] > nums[i - 1])
                ans[i] = true;
            if (i > 0 && i < n - 1 && nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                ans[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i])
                return i;
        }
        return (n == 1) ? 0 : -1;
    }
}