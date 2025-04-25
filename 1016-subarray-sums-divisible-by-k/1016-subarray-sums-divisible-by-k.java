class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int cnt = 0;
        int pre_sum = 0;

        Map<Integer, Integer> freq = new HashMap<>(k);
        freq.put(0, 1);

        for (int x : nums) {
            pre_sum += x;

            int m = ((pre_sum % k) + k) % k; // Ensures the remainder is non-negative

            cnt += freq.getOrDefault(m, 0);

            freq.put(m, freq.getOrDefault(m, 0) + 1);
        }

        return cnt;
    }
}
