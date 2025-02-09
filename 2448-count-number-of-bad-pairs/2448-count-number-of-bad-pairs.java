class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long total = 0; // Total combination Possible

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Find nums[i]-i 0R nums[j]-j
            int diff = nums[i] - i;
            // If we seen that bad pair already
            int prevcount = map.getOrDefault(diff, 0);
            total += i - prevcount;
            map.put(diff, prevcount + 1);
        }
        return total;
    }
}