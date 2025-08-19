class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                long len = (j - i);
                ans += (len * (len + 1)) >> 1;
                i = j;
            } else
                i++;

        }
        return ans;
    }
}