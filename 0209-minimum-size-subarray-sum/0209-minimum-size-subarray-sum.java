class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, psum = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            psum += nums[j];
// the minimal length of a subarray whose sum is greater than or equal to target
            while (psum >= target) {
                psum -= nums[i];
                ans = Math.min(ans, j - i + 1);
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}