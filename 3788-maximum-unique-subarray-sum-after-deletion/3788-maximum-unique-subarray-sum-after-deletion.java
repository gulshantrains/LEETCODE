class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        int ncnt = 0, minn = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ncnt++;
                minn = Math.max(minn, nums[i]);
            }
        }

        if (ncnt != nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0 && !st.contains(nums[i])) {
                    ans += nums[i];
                    st.add(nums[i]);
                }
            }
        } else {
            return minn;
        }

        return ans;
    }
}