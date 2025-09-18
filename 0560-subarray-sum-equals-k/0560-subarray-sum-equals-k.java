class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] cum = new int[nums.length + 1];
        cum[0] = 0;
        int ans = 0;

        for (int i = 1; i <= nums.length; i++) {
            cum[i] = cum[i - 1] + nums[i - 1];
        }

        for (int start = 0; start < cum.length; start++) {
            for (int end = start + 1; end < cum.length; end++) {
                if (cum[end] - cum[start] == k)
                    ans++;
            }
        }
        return ans;
    }
}