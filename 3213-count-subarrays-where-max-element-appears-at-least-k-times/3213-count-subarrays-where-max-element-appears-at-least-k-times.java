class Solution {
    public long countSubarrays(int[] nums, int k) {
        long cnt = 0, ans = 0;
        int n = nums.length;
        int i = 0;

        int max = Arrays.stream(nums).max().getAsInt();

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