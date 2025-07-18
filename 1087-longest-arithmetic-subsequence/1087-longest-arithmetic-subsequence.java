class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        
        // Initialize the max length. Any pair of numbers forms a sequence of length 2.
        int maxLength = 2;

        // dp[end_index][difference] = length
        // The difference can range from -500 to 500. We use an offset of 500
        // to map this range to the array indices [0, 1000].
        int[][] dp = new int[n][1001];
        
        // We can think of every single number as an arithmetic sequence of length 1.
        // This provides the base case for our DP transition.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        // Iterate through all possible pairs (j, i) to build sequences.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int diffIndex = diff + 500; // Apply offset for a valid index

                // The new sequence ending at 'i' is 1 longer than the sequence ending at 'j'.
                // Since dp[j][...] was initialized to 1, a new pair (j,i) will have length 1+1=2.
                dp[i][diffIndex] = dp[j][diffIndex] + 1;

                // Update the overall maximum length found.
                maxLength = Math.max(maxLength, dp[i][diffIndex]);
            }
        }
        
        return maxLength;
    }
}