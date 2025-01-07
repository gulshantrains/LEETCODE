class Solution {
    public int smallestEqual(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                if (ans == -1)
                    ans = i;
                ans = Math.min(ans, i);
            }
        }
        return ans;
    }
}