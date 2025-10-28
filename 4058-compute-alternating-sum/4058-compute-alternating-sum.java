class Solution {
    public int alternatingSum(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += ((i & 1) == 0 ? nums[i] : -nums[i]);
        }
        return total;
    }
}