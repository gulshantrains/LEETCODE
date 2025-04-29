class Solution {
    public long countSubarrays(int[] nums, int k) {
        int cnt = 0;
        long ans = 0;
        int n = nums.length;
        int i = 0;
        int max = Integer.MIN_VALUE;

        for (var x : nums)
            if (x > max)
                max = x;

        for (int j = 0; j < n; j++) {
            if (nums[j] == max) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[i++] == max) {
                    cnt--;
                }
                ans += (n - j);
            }
        }
        return ans;
    }
}