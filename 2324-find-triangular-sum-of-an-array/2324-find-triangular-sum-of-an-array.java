class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;
        int nidx = len - 1;
        if (len == 1)
            return nums[0];

        while (len > 1) {
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] < 0)
                    break;

                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums[(len - 1)] = -1;
            len--;
        }
        return nums[0];
    }
}