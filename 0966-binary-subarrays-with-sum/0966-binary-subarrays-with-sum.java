class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, ans = 0;

        for (int i = 0; i < n; i++) {
            int rsum = 0;
            for (int j = i; j < n; j++) {
                rsum += nums[j];

                if (rsum == goal)
                    ans++;

                if (rsum > goal)
                    break;
            }

        }
        return ans;
    }
}