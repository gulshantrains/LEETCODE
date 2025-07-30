class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxAnd = 0;

        for (int x : nums)
            maxAnd = Math.max(x, maxAnd);

        int maxLen = 0, currLen = 0;

        for (int x : nums) {
            if (x == maxAnd) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else
                currLen = 0;
        }
        return maxLen;

    }
}