class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;

        int n = nums.length;

        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        // Calculate leftmax array
        // leftmax[i] stores the maximum in the block segment ending at i.
        leftmax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // If 'i' is the start of a new block (i.e., multiple of k),
            // then the max for this block starts with nums[i].
            // Otherwise, it's the max of current num and previous leftmax in the same block.
            if (i % k == 0) {
                leftmax[i] = nums[i];
            } else {
                leftmax[i] = Math.max(nums[i], leftmax[i - 1]);
            }
        }

        // Calculate rightmax array
        // rightmax[i] stores the maximum in the block segment starting at i.
        rightmax[n - 1] = nums[n - 1]; // Last element is always the max for its block segment
        for (int i = n - 2; i >= 0; i--) {
            // If 'i+1' is the start of a new block (meaning 'i' is the end of the previous block),
            // then the max for this block segment starting at 'i' is just nums[i].
            // Otherwise, it's the max of current num and next rightmax in the same block.
            if ((i + 1) % k == 0) { // Check if nums[i] is the end of a block looking from right to left
                rightmax[i] = nums[i];
            } else {
                rightmax[i] = Math.max(nums[i], rightmax[i + 1]);
            }
        }

        int size = n - k + 1;
        int[] ans = new int[size];

        for (int j = 0; j <= n - k; j++) {
            // For each window starting at 'j' and ending at 'j + k - 1':
            // The maximum is the greater of:
            // 1. The maximum from 'j' to the end of its block (rightmax[j])
            // 2. The maximum from the start of the block containing 'j+k-1' to 'j+k-1' (leftmax[j + k - 1])
            ans[j] = Math.max(rightmax[j], leftmax[j + k - 1]);
        }

        return ans;
    }
}