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

        if (k == 0)
            return res;
        else if (k % 2 != 0) {
            res -= 2 * min;
        }

        return res;

    }
}