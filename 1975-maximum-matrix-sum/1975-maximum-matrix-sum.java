class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                sum += Math.abs(val);

                if (val < 0) negativeCount++;

                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        return (negativeCount % 2 == 0) ? sum : sum - 2L * minAbs;
    }
}

/*
-------------------- THOUGHT PROCESS --------------------

1. Observation:
   - Flipping two adjacent elements multiplies both by -1.
   - This operation keeps the parity (even/odd) of negative numbers unchanged.
   - Therefore, we can rearrange signs freely EXCEPT for the final parity of negatives.

2. Goal:
   - Maximize total sum ⇒ make all values positive if possible.

3. Strategy:
   - Add absolute value of every element (best possible sum).
   - Count total negative elements.
   - Track the smallest absolute value in the matrix.

4. Key Rule:
   - If number of negatives is EVEN:
       → All numbers can be made positive.
       → Answer = sum of absolute values.
   - If number of negatives is ODD:
       → One element must remain negative.
       → Choose the smallest absolute value to minimize loss.
       → Subtract (2 × smallest absolute value).

5. Final Formula:
   - Even negatives  → sum
   - Odd negatives   → sum - 2 × minAbs

-------------------- PATTERN --------------------

✔ Grid sign-flipping problems  
✔ Operation preserves parity of negatives  
✔ Convert to absolute sum + parity adjustment  
✔ Greedy choice: sacrifice the smallest value if needed

Time Complexity:  O(n²)  
Space Complexity: O(1)

------------------------------------------------
*/
