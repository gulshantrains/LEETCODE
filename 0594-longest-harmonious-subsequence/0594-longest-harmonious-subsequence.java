class Solution {
    public int findLHS(int[] nums) {
        // Handle edge cases: if the array is null or has fewer than 2 elements, a harmonious subsequence is not possible.
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // Use a HashMap to store the frequency of each number in the array.
        // Key: the number from the array.
        // Value: the count of how many times that number appears.

        Map<Integer, Integer> mp = new HashMap<>();

        // This variable will store the maximum length found so far.
        int ans = 0;

        // Iterate through each number in the input array.
        for (int num : nums) {
            // Increment the frequency count for the current number.
            mp.put(num, mp.getOrDefault(num, 0) + 1);

            // A harmonious subsequence can be formed by the current number `num` and its adjacent numbers (`num + 1` or `num - 1`).
            // We check for both possibilities.

            // Case 1: Check if a subsequence can be formed with `num` and `num + 1`.
            if (mp.containsKey(num + 1)) {
                // If `num + 1` exists in our map, calculate the combined length.
                int currentLength = mp.get(num) + mp.get(num + 1);
                // Update the maximum length if this new subsequence is longer.
                ans = Math.max(ans, currentLength);
            }

            // Case 2: Check if a subsequence can be formed with `num` and `num - 1`.
            if (mp.containsKey(num - 1)) {
                // If `num - 1` exists, calculate the combined length.
                int currentLength = mp.get(num) + mp.get(num - 1);
                // Update the maximum length if this new subsequence is longer.
                ans = Math.max(ans, currentLength);
            }

        }

        // Return the maximum length found during the iteration.
        return ans;
    }
}