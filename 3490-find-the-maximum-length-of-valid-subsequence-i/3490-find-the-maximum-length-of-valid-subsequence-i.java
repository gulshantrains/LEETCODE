class Solution {
    public int maximumLength(int[] nums) {
        // Initialize 'c' with the parity of the first element.
        // This 'c' variable will keep track of the *expected* parity for the alternating subsequence.
        int c = nums[0] % 2;

        // 'odd' counts the length of the longest subsequence containing only odd numbers.
        int odd = 0;

        // 'even' counts the length of the longest subsequence containing only even numbers.
        int even = 0;

        // 'both' counts the length of the longest subsequence with alternating parities.
        int both = 0;

        // Iterate through each number in the input array.
        for (int num : nums) {
            // Case 1: Subsequence of only even numbers
            if (num % 2 == 0) {
                even++; // Increment count if the current number is even.
            } else {
                // Case 2: Subsequence of only odd numbers
                odd++; // Increment count if the current number is odd.
            }

            // Case 3: Subsequence with alternating parities
            // Check if the current number's parity matches the 'expected' parity (c) for the alternating sequence.
            if (num % 2 == c) {
                both++;       // If it matches, extend the alternating subsequence.
                c = 1 - c;    // Toggle 'c' to the *next expected* parity for the alternating sequence.
                              // If c was 0 (even), it becomes 1 (odd). If c was 1 (odd), it becomes 0 (even).
            }
        }

        // The maximum length is the longest among the three types of valid subsequences.
        return Math.max(both, Math.max(even, odd));
    }
}