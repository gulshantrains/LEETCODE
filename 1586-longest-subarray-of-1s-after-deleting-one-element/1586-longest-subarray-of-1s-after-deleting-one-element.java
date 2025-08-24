class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, ans = Integer.MIN_VALUE, zero = 0;
        int sum=0;
        for(int x: nums) sum+=x;

        if(sum==nums.length) return sum-1;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zero++;

            while (zero > 1) {
                if (nums[left] == 0)
                    zero--;
                left++;
            }
            ans = Math.max(ans, right - left + 1 - 1);
        }
        return ans;
    }
}