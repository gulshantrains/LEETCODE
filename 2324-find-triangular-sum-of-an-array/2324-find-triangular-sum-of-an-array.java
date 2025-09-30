import java.math.BigInteger;

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger c = BigInteger.ONE; // C(n-1,0)
        BigInteger ans = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            ans = ans.add(c.multiply(BigInteger.valueOf(nums[i])));

            if (i < n - 1) {
                // compute next coefficient
                c = c.multiply(BigInteger.valueOf(n - 1 - i))
                     .divide(BigInteger.valueOf(i + 1));
            }
        }

        return ans.mod(BigInteger.TEN).intValue();
    }
}
