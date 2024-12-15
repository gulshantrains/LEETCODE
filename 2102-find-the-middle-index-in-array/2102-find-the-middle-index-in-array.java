class Solution {
    public int findMiddleIndex(int[] nums) {
        int tsum = 0, leftSum = 0;

        for (int x : nums)
            tsum += x;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == tsum - leftSum - nums[i])
                return i;

            leftSum += nums[i];
        }
        return -1;
    }
}