class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        // 1. Find the maximum value in the array
        int maxAnd = 0;
        for (int x : nums)
            maxAnd = Math.max(x, maxAnd);

        // 2. Initialize counters for current streak and max streak
        int maxLen = 0, currLen = 0;

        // 3. Loop to find the longest contiguous segment of maxAnd
        for (int x : nums) {
            if (x == maxAnd) {
                currLen++;                          // continue streak
                maxLen = Math.max(maxLen, currLen); // update max length
            } else {
                currLen = 0; // reset streak if element not equal to max
            }
        }

        // 4. Return the max length found
        return maxLen;
    }
}
