class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 2) {
                res[i] = -1;
                continue;
            }

            boolean found = false;

            for (int j = 1; j < 32; j++) {
                if ((nums.get(i) & (1 << j)) > 0)
                    continue;

                int idx = j - 1;
                int val = (nums.get(i) ^ (1 << (j - 1)));
                res[i] = val;
                found = true;
                break;
            }
            if (!found)
                res[i] = -1;
        }

        return res;
    }
}
/**
 * -----------------------------------------------------------------------
 * IMPORTANT OBSERVATION:
 *
 * Bitwise OR of two consecutive numbers (x and x+1) has a special property:
 *
 * - The lowest 0 bit in x becomes 1 when adding 1
 * - All lower bits become 1
 *
 * Example:
 *   x     = 101000
 *   x + 1 = 101001
 *   OR    = 101001
 *
 * So, to achieve nums[i], we try to "remove" exactly one bit
 * from nums[i] such that OR with next number restores nums[i].
 *
 * -----------------------------------------------------------------------
 * SPECIAL CASE:
 *
 * nums[i] == 2
 * Binary of 2 = 10
 *
 * There is NO integer x such that:
 *   x OR (x + 1) == 2
 *
 * Hence, answer is -1.
 *
 * ========================= CODE EXPLANATION =========================
 *
 * public int[] minBitwiseArray(List<Integer> nums)
 * ------------------------------------------------
 * We iterate over each element nums[i] and try to find the smallest
 * possible ans[i].
 *
 * Step-by-step explanation:
 *
 * 1. Initialize result array `res` of same size as nums.
 *
 * 2. For each index i:
 *
 *    a) If nums[i] == 2:
 *       - Directly assign res[i] = -1
 *       - Continue to next index
 *
 *    b) Otherwise:
 *       - We try to find a bit position `j` (1 to 31)
 *         such that the j-th bit in nums[i] is 0.
 *
 *       - Why?
 *         Because flipping the (j-1)-th bit of nums[i]
 *         will produce a candidate value `val`
 *         where:
 *            val OR (val + 1) == nums[i]
 *
 *    c) For each bit position j:
 *
 *       if ((nums[i] & (1 << j)) > 0)
 *           continue;
 *
 *       - This checks whether the j-th bit is already set.
 *       - If it is set, skip it.
 *
 *       int val = nums[i] ^ (1 << (j - 1));
 *
 *       - XOR flips the (j-1)-th bit.
 *       - This generates the SMALLEST possible candidate first
 *         because we start from lower bits.
 *
 *       - Assign res[i] = val
 *       - Mark found = true
 *       - Break the loop since we want minimum ans[i]
 *
 *    d) If no such bit position was found:
 *       - Assign res[i] = -1
 *
 * 3. Return the result array.
 *
 * ========================= TIME & SPACE COMPLEXITY =========================
 *
 * Time Complexity:
 *   O(n * 32) ≈ O(n)
 *
 * Space Complexity:
 *   O(n) for the result array
 *
 */
