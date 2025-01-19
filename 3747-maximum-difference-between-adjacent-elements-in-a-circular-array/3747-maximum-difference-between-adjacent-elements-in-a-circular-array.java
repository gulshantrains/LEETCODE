class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //Use % n for wrap around and if index is negative the add kro n to make
            //Positive and then wrap around kro
            int lsum = Math.abs(nums[i % n] - nums[(i - 1 + n) % n]);
            int rsum = Math.abs(nums[i % n] - nums[(i + 1) % n]);

            ans = Math.max(ans, Math.max(lsum, rsum));
        }
        return ans;
    }
}