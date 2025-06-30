import java.util.Arrays;

class Solution {
    // Define a constant for the modulo operation to prevent overflow and ensure results are within the required range.
    public static int mod = (int) 1e9 + 7;

    /**
     * This method calculates the number of non-empty subsequences of an array `nums`
     * such that the sum of the minimum and maximum elements of the subsequence is less than or equal to `target`.
     *
     * @param nums   The input array of integers.
     * @param target The target integer value.
     * @return The number of valid subsequences modulo 10^9 + 7.
     */
    public int numSubseq(int[] nums, int target) {
        // 1. Sort the array in non-decreasing order.
        // Sorting is crucial because it allows us to efficiently find the minimum (nums[l])
        // and maximum (any element from nums[l] to nums[r]) elements for potential subsequences.
        // Once we fix the minimum element as nums[l], we know that any other element included
        // from the subarray nums[l...r] will result in a maximum that is at most nums[r].
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0, r = n - 1; // Initialize two pointers: l at the start and r at the end of the array.
        int ans = 0;          // This will store the total count of valid subsequences.

        // 2. Pre-compute powers of 2.
        // We need to calculate 2^(r-l) frequently. Pre-computing these values
        // avoids redundant calculations inside the loop and prevents potential time limit exceeded errors.
        // pows[i] will store 2^i % mod.
        int[] pows = new int[n];
        pows[0] = 1; // 2^0 = 1
        for (int i = 1; i < n; i++) {
            // Calculate powers of 2 using the previous value to maintain efficiency.
            // (a * b) % mod = ((a % mod) * (b % mod)) % mod
            pows[i] = (pows[i - 1] * 2) % mod;
        }

        // 3. Use a two-pointer approach to find valid subsequences.
        // The pointer `l` will represent the minimum element of a potential subsequence.
        // The pointer `r` will help us find the upper bound for the maximum element.
        while (l <= r) {
            // Check if the sum of the smallest possible minimum (nums[l]) and the largest
            // possible maximum (nums[r]) for the current window is within the target.
            if (nums[l] + nums[r] <= target) {
                // If nums[l] + nums[r] <= target, it means that for the fixed minimum element `nums[l]`,
                // any subsequence formed by `nums[l]` and some elements from the subarray `nums[l+1...r]`
                // will also satisfy the condition. This is because the minimum will always be `nums[l]`
                // and the maximum will be at most `nums[r]`.

                // The elements between `l` and `r` (i.e., from index l+1 to r) are `r - l` elements.
                // For each of these `r - l` elements, we can either include it in the subsequence or not.
                // This gives us 2 choices for each element.
                // Therefore, there are 2^(r-l) possible subsequences that have `nums[l]` as their minimum element.
                int count = pows[r - l];

                // Add the count of these new subsequences to our total answer.
                // We use modulo arithmetic at each addition to prevent the sum from overflowing.
                ans = (ans + count) % mod;

                // Since we have now counted all valid subsequences that can be formed with `nums[l]`
                // as the minimum element, we can move to the next potential minimum element.
                l++;
            } else {
                // If nums[l] + nums[r] > target, the sum is too large.
                // To satisfy the condition, we need a smaller maximum element.
                // Since the array is sorted, we move the right pointer `r` one step to the left
                // to consider a smaller potential maximum.
                r--;
            }
        }
        return ans;
    }
}