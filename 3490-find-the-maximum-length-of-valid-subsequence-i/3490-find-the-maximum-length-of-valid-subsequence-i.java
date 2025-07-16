class Solution {
    public int maximumLength(int[] nums) {
        // `expP` (expected parity): Stores the parity (0 for even, 1 for odd)
        // expected for the next element in the alternating subsequence.
        // Initialized with the parity of the first element.
        int expP = nums[0] % 2;

        // `oddC` (odd count): Tracks the length of the longest subsequence with only odd numbers.
        int oddC = 0;

        // `evenC` (even count): Tracks the length of the longest subsequence with only even numbers.
        int evenC = 0;

        // `altC` (alternating count): Tracks the length of the longest alternating parity subsequence.
        int altC = 0;

        // Iterate through each number in the input array.
        for (int n : nums) { // `n` for number
            // Update counts for purely even or purely odd subsequences.
            if (n % 2 == 0) {
                evenC++;
            } else {
                oddC++;
            }

            // Update count for the alternating subsequence.
            if (n % 2 == expP) {
                altC++;
                // Toggle `expP` for the next expected parity.
                expP = 1 - expP;
            }
        }

        // Return the maximum length found among the three types.
        return Math.max(altC, Math.max(evenC, oddC));
    }
}