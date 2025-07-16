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

/*
All these sums must have the same parity (either all even sums or all odd sums).

Let's analyze the parity of sums:

Even + Even = Even
Odd + Odd = Even
Even + Odd = Odd
Odd + Even = Odd

From this, we can deduce some key patterns for a valid subsequence:

All Even Numbers: If a subsequence consists only of even numbers (e.g., [2,4,6]), then (Even + Even) 
...will always be Even. The sums will all have even parity.

All Odd Numbers: If a subsequence consists only of odd numbers (e.g., [1,3,5]), then (Odd + Odd) 
...will always be Even. The sums will all have even parity.

Alternating Parity: If a subsequence alternates between odd and even numbers (e.g., [1,2,3,4] or [2,1,4,3]), 
...then (Odd + Even) and (Even + Odd) will always be Odd. The sums will all have odd parity.

Therefore, the problem boils down to finding the longest subsequence that is either:
Composed entirely of even numbers.
Composed entirely of odd numbers.
Composed of numbers with strictly alternating parities.
*/
