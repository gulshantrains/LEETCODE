class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] frequency = new int[nums.length + 1]; // To track frequency updates

        // Process each query to mark the ranges
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            frequency[l] += 1; // Start incrementing from index l
            if (r + 1 < nums.length) {
                frequency[r + 1] -= 1; // Stop incrementing after index r
            }
        }
        int runningsum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningsum += frequency[i];

            nums[i] -= runningsum;

            if (nums[i] > 0)
                return false;

        }
        return true;
    }
}
