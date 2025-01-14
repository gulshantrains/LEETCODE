class Solution {
    public int maxProduct(int[] nums) {
        int maxx = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i]-1;

            for (int j = i + 1; j < nums.length; j++) {
                int xx = nums[j]-1;

                maxx = Math.max(maxx, x * xx);
            }
        }
        return maxx;
    }
}