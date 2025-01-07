class Solution {
    public int smallestEqual(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i] && ans > i) {
                ans = i;
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}