class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            //System.out.println(nums[nums[i]]);
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}