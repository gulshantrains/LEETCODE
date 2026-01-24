class Solution {
    public int minPairSum(int[] nums) {
        int ans = -(int) 1e9 + 7;
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;

        while (i < j) {
            int pair_sum = nums[i++] + nums[j--];

            ans = Math.max(pair_sum, ans);
        }

        return ans;
    }
}