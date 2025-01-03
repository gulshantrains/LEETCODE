class Solution {
    public int waysToSplitArray(int[] nums) {
        int cnt = 0;
        long rSum = 0;
        long lSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            lSum += nums[i];
            rSum -= nums[i];

            if (lSum >= rSum)
                cnt++;
        }
        return cnt;

    }
}