class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        // First, check if using all queries can satisfy the nums array
        if (!can(nums, queries, queries.length))
            return -1;

        // BS to find the minimum number of queries needed
        int l = 0, r = queries.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // If the first 'mid' queries are enough, try to find a smaller answer
            if (can(nums, queries, mid))
                r = mid - 1;
            else
                l = mid + 1; // Otherwise, try more queries
        }

        return l;
    }

    //Zero Array Transformation i :)
    private boolean can(int[] nu, int[][] qu, int range) {
        int[] temp = new int[nu.length + 1]; 

        // Apply the first 'range' queries to the temp array
        for (int i = 0; i < range; i++) {
            int l = qu[i][0];
            int r = qu[i][1];
            int val = qu[i][2];

            // Add 'val' at start index and subtract it after end index
            temp[l] += val;
            temp[r + 1] -= val;
        }

        // Convert difference array to actual prefix sum values
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }

        // Check if every position in 'nu' is satisfied by the updates
        for (int i = 0; i < nu.length; i++) {
            if (temp[i] < nu[i]) // Not enough value added at index i
                return false;
        }

        // All positions are satisfied
        return true;
    }
}
