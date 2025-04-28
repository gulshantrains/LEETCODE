class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i = 0, n = nums.length; long ans = 0, temp = 0;

        for (int j = 0; j < n; j++) {
            temp += nums[j];

            while (temp * (j - i + 1) >= k) {
                temp -= nums[i++];
            }
            ans += j - i + 1;

        }
        return ans;
    }
}