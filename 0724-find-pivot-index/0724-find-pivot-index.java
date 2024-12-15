class Solution {
    public int pivotIndex(int[] nums) {
        int[][] mt = new int[nums.length][3];
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        mt[0][0] = 0;
        mt[0][1] = 0;
        mt[0][2] = sum - nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (mt[i - 1][0] == mt[i - 1][2])
                return i-1;

            mt[i][0] = mt[i - 1][0] + nums[i - 1];
            mt[i][1] = i;
            mt[i][2] = mt[i - 1][2] - nums[i];
        }
        if (mt[nums.length - 1][0] == mt[nums.length - 1][2]) {
            return nums.length - 1;
        }
        return -1;
    }
}