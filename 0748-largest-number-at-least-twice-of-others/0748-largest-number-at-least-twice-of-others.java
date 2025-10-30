class Solution {
    public int dominantIndex(int[] nums) {
        int max = -11, idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        Arrays.sort(nums);

        return (2 * nums[nums.length - 2] <= nums[nums.length - 1] ? idx : -1);
    }
}