class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, min = 10_000_000, res = 0;

        for (int i = 0; i < n; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] *= -1;
                k--;

            } else
                break;
        }
        for (int x : nums) {
            min = Math.min(min, x);
            res += x;
        }

        return res - (k % 2) * 2 * min;
    }
}