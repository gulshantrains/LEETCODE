class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> bag = new HashMap<>(); // Store occurrences of `nums[i] - i`
        long count = 0; // Count of good pairs
        for (int i = 0; i < nums.length; i++) {
            // Compute the difference for the current element
            int diff = nums[i] - i;
            // Add the count of previous elements with the same difference
            count += bag.getOrDefault(diff, 0);
            // Update the count of this difference in the map
            bag.put(diff, bag.getOrDefault(diff, 0) + 1);
        }
        int len = nums.length;
        // Total pairs minus good pairs gives bad pairs
        return 1L * len * (len - 1) / 2 - count;
    }
}
