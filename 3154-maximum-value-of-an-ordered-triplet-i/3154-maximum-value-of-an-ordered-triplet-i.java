class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long diff = (nums[i] - nums[j]);
                    long val=diff*nums[k];
                    if (val < 0)
                        val = 0;
                    ans = Math.max(ans, val);
                }
            }
        }
        return ans;
    }
}