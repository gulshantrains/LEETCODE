// Class to handle combinations modulo M using precomputed factorials and their inverses
class Combinations {
    long[] fact; // Stores factorials modulo M
    long[] invFact; // Stores inverse factorials modulo M
    long M; // The modulus

    /**
     * Constructor precomputes factorials and their modular inverses up to n.
     * @param n The maximum value for which factorials/inverses are needed.
     * @param mod The modulus.
     */
    public Combinations(int n, long mod) {
        M = mod;
        // Need arrays of size n+1 to store values from index 0 to n
        fact = new long[n + 1];
        invFact = new long[n + 1];

        // Base cases for factorial and inverse factorial
        fact[0] = 1;
        invFact[0] = 1;

        // Precompute factorials and inverse factorials iteratively
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
            // Calculate modular inverse using Fermat's Little Theorem: a^(M-2) % M
            // This requires M to be a prime number. 10^9 + 7 is prime.
            invFact[i] = power(fact[i], M - 2);
        }
    }

    /**
     * Calculates modular exponentiation (base^exp % M) using binary exponentiation.
     * @param base The base.
     * @param exp The exponent.
     * @return (base^exp) % M.
     */
    long power(long base, long exp) {
        long res = 1;
        base %= M;
        while (exp > 0) {
            // If exponent is odd, multiply result with base
            if (exp % 2 == 1) res = (res * base) % M;
            // Square the base and halve the exponent
            base = (base * base) % M;
            exp /= 2;
        }
        return res;
    }

    /**
     * Calculates combinations "n choose r" modulo M (nCr % M).
     * @param n The total number of items.
     * @param r The number of items to choose.
     * @return nCr % M.
     */
    long nCr(int n, int r) {
        // Handle invalid inputs where r < 0 or r > n
        if (r < 0 || r > n) {
            return 0;
        }
        // Using the formula: nCr = n! / (r! * (n-r)!) mod M
        // Which is equivalent to: nCr = n! * inv(r!) * inv((n-r)!) mod M
        // Ensure n, r, n-r are within the bounds of precomputed arrays (0 to max_n)
        long num = fact[n];
        long den = (invFact[r] * invFact[n - r]) % M; // Calculate denominator inverse part
        return (num * den) % M; // Final result
    }
}

class Solution {
    // Define the modulus as a constant
    private static final int MOD = 1_000_000_007;

    /**
     * Calculates the number of distinct ideal arrays of length n with values up to maxValue.
     * An array arr is ideal if:
     * 1. 1 <= arr[i] <= maxValue for 0 <= i < n.
     * 2. arr[i] is divisible by arr[i-1] for 0 < i < n.
     *
     * The approach combines dynamic programming and combinatorics.
     * An ideal array has a sequence of distinct values d1 < d2 < ... < dk such that d_i divides d_{i+1}.
     * Let dp[k][x] be the number of such sequences of length k ending with value x (where x <= maxValue).
     * The total number of ideal arrays is Sum_{k=1 to n} [ (Sum_{x=1 to maxValue} dp[k][x]) * C(n-1, k-1) ].
     * C(n-1, k-1) represents the number of ways to place k distinct values into n array slots non-decreasingly.
     *
     * The implementation iteratively computes the total count of sequences for each length k.
     * Let `dp[x]` store the count of sequences of length `k-1` ending at `x`.
     * `next_dp[x]` stores the count of sequences of length `k` ending at `x`.
     * `next_dp[i] = Sum_{j | i, j < i} dp[j]`. This sum is computed efficiently using a multiples iteration.
     *
     * @param n        The length of the ideal array (constraints: 2 <= n <= 10^4).
     * @param maxValue The maximum value allowed for elements (constraints: 1 <= maxValue <= 10^4).
     * @return The number of distinct ideal arrays modulo 10^9 + 7.
     */
    public int idealArrays(int n, int maxValue) {
        // Precompute combinations C(n-1, k-1). The maximum value for the first argument is n-1.
        // The Combinations class needs to handle factorials up to n (for safety, or n-1 precisely).
        Combinations comb = new Combinations(n, MOD);

        // dp[i] stores the count of distinct-value sequences of the current length `k-1` ending at `i`.
        long[] dp = new long[maxValue + 1];
        long totalAns = 0; // Accumulates the total count of ideal arrays

        // Base case: k = 1 (sequences with 1 distinct value)
        // The sequences are [1], [2], ..., [maxValue]. The count is maxValue.
        long count_k1 = maxValue;
        // Combinations factor for placing 1 value in n slots: C(n-1, 1-1) = C(n-1, 0) = 1.
        totalAns = (totalAns + count_k1 * comb.nCr(n - 1, 0)) % MOD;

        // Initialize dp array representing counts for sequences of length k=1.
        // dp[i] = 1 means there is one sequence of length 1 ending at i: [i].
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
        }

        // Iterate for k = 2 upwards. k represents the number of distinct values in the sequence.
        // The maximum number of distinct values k is limited by n.
        // It's also limited by roughly log2(maxValue), because if d1 >= 1, dk >= 2^(k-1).
        // For maxValue=10000, log2(10000) is about 13.3. So k_max is around 14.
        // We use a safe fixed upper bound like 16, considering constraints. The loop will break early if counts become 0.
        int kLimit = Math.min(n, 16); // Effective limit for k

        for (int k = 2; k <= kLimit; k++) {
            // next_dp[i] will store the count of distinct-value sequences of length `k` ending at `i`.
            long[] next_dp = new long[maxValue + 1];

            // Compute next_dp using the current dp (representing counts for length k-1).
            // next_dp[i] = Sum_{j | i, j < i} dp[j]
            // This is efficiently computed by iterating through multiples j and adding dp[j] to its multiples i=m*j (m>1).
            // Complexity per k: O(maxValue * log maxValue).
            for (int j = 1; j <= maxValue; j++) {
                // If dp[j] (count for length k-1 ending at j) is 0, it cannot extend any sequence.
                if (dp[j] == 0) continue;

                // Iterate through multiples i = m*j, where m >= 2 (so i > j).
                for (long i = 2L * j; i <= maxValue; i += j) {
                    // Add the count of sequences ending at j (dp[j]) to the count of sequences ending at i (next_dp[i]).
                    // Explicit cast to int for array index access.
                    next_dp[(int)i] = (next_dp[(int)i] + dp[j]) % MOD;
                }
            }

            // Calculate the total count of distinct-value sequences of length k ending <= maxValue.
            long current_total_count = 0;
            for (int i = 1; i <= maxValue; i++) {
                 current_total_count = (current_total_count + next_dp[i]) % MOD;
            }

            // If the total count for length k is 0, then no sequences of length > k can exist.
            // We can stop the iteration early.
            if (current_total_count == 0) {
                break;
            }

            // Calculate the combinations factor C(n-1, k-1). This represents the number of ways
            // to place the k distinct values into the n slots of the array while maintaining order.
            long combinations_factor = comb.nCr(n - 1, k - 1);

            // Add the contribution for length k sequences to the total answer.
            // Contribution = (total count of sequences of length k) * (ways to place k values in n slots)
            totalAns = (totalAns + current_total_count * combinations_factor) % MOD;

            // Update dp array for the next iteration (k+1). The counts for length k become the basis.
            dp = next_dp;
        }

        // Return the final computed total number of ideal arrays modulo MOD.
        return (int) totalAns;
    }
}