class Solution {

    /**
     * Inner class representing the Fenwick Tree (Binary Indexed Tree).
     * It supports point updates and range sum queries efficiently.
     */
    private class FenwickTree {
        private int[] tree;
        private int size;

        /**
         * Constructor for Fenwick Tree.
         * @param size The maximum value expected + 1 (since values can be 0).
         * The tree uses 1-based indexing internally.
         */
        public FenwickTree(int size) {
            // Size should be max possible value + 1
            // e.g., if values are 0-1000, size should be 1001
            this.size = size;
            this.tree = new int[size + 1]; // 1-based indexing
        }

        /**
         * Updates the frequency count for value 'val' by 'delta'.
         * Internally converts 0-based value 'val' to 1-based index.
         * Time Complexity: O(log M) where M is the size.
         */
        public void update(int val, int delta) {
            int idx = val + 1; // Convert value to 1-based index
            while (idx <= size) {
                tree[idx] += delta;
                idx += idx & (-idx); // Move to the next index covering this one
            }
        }

        /**
         * Queries the cumulative frequency count from value 0 up to 'val' (inclusive).
         * Internally converts 0-based value 'val' to 1-based index.
         * Time Complexity: O(log M) where M is the size.
         */
        public int query(int val) {
            int idx = val + 1; // Convert value to 1-based index
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & (-idx); // Move to the index covering the prefix
            }
            return sum;
        }

        /**
         * Queries the sum of frequencies for values in the range [left, right] (inclusive).
         * Time Complexity: O(log M) where M is the size.
         */
        public int queryRange(int left, int right) {
            if (left > right) {
                return 0; // Invalid range
            }
            // query(right) gives sum up to value 'right'
            // query(left - 1) gives sum up to value 'left - 1'
            // The difference gives the sum in the range [left, right]
            return query(right) - query(left - 1);
        }
    }

    /**
     * Counts the number of good triplets (i, j, k) such that i < j < k and:
     * 1. abs(arr[i] - arr[j]) <= a
     * 2. abs(arr[j] - arr[k]) <= b
     * 3. abs(arr[i] - arr[k]) <= c
     *
     * Uses a Fenwick Tree for an O(N^2 * log M) solution, where M is the value range.
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        if (n < 3) {
            return 0; // Cannot form a triplet
        }

        long total_ans = 0; // Use long to prevent potential overflow if count is large

        // --- Determine maxVal ---
        // Using a fixed common constraint. Adjust if problem specifies otherwise.
        // Alternatively, find max in arr:
        // int maxVal = 0;
        // for (int x : arr) { maxVal = Math.max(maxVal, x); }
        int maxVal = 1000; // Assuming values are in [0, 1000]

        // Initialize the Fenwick Tree (BIT) for prefix counts.
        // Size needs to accommodate values from 0 to maxVal.
        FenwickTree prefix_bit = new FenwickTree(maxVal + 1);

        // Iterate through the potential middle element 'j'
        // j starts at 1 because we need i = j-1.
        // j ends at n-1 because we need k = j+1.
        for (int j = 1; j < n; j++) {

            // 1. Update BIT with the element arr[j-1] (this is a potential 'i')
            //    This makes arr[j-1]'s value count available for queries
            //    when considering triplets where j is the middle element.
            prefix_bit.update(arr[j-1], 1);

            // 2. Iterate through the potential third element 'k' (k > j)
            for (int k = j + 1; k < n; k++) {

                // 3. Check the condition involving j and k first
                if (Math.abs(arr[j] - arr[k]) <= b) {

                    // 4. If condition 'b' holds, determine the required range for arr[i]
                    //    based on conditions 'a' (with j) and 'c' (with k).
                    //    Range for arr[i] from condition 'a': [arr[j]-a, arr[j]+a]
                    //    Range for arr[i] from condition 'c': [arr[k]-c, arr[k]+c]
                    int lower_a = arr[j] - a;
                    int upper_a = arr[j] + a;
                    int lower_c = arr[k] - c;
                    int upper_c = arr[k] + c;

                    // Find the intersection of the two ranges and clamp within [0, maxVal]
                    int final_lower = Math.max(0, Math.max(lower_a, lower_c));
                    int final_upper = Math.min(maxVal, Math.min(upper_a, upper_c));

                    // 5. Query the BIT for the count of elements arr[i] (where i < j)
                    //    that fall within the valid intersecting range [final_lower, final_upper].
                    if (final_lower <= final_upper) {
                        int count_i = prefix_bit.queryRange(final_lower, final_upper);
                        total_ans += count_i;
                    }
                }
            }
        }

        // Cast the final answer back to int if it's guaranteed to fit.
        // The problem asks for an int return type.
        // If intermediate sums could exceed Integer.MAX_VALUE, using long is safer.
        // If the final result can exceed Integer.MAX_VALUE, the problem statement
        // or return type might be different. Assuming result fits in int.
        return (int)total_ans;
    }
}