class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums.length; i++) {
            // Start from the next element and search circularly
            for (int k = 1; k < nums.length; k++) {
                int j = (i + k) % nums.length;
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
}