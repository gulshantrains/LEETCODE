import java.math.BigInteger;
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        BigInteger c = BigInteger.ONE; // start with C(n-1,0) = 1
        BigInteger[] coeF = new BigInteger[n];
        coeF[0] = c;

        // compute binomial coefficients exactly (BigInteger)
        for (int i = 1; i < n; i++) {
            // c = c * (n-i) / i
            c = c.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i));
            coeF[i] = c;
        }

        // compute weighted sum modulo 10
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            ans = ans.add(BigInteger.valueOf(nums[i])
                    .multiply(coeF[i]));
        }

        return ans.mod(BigInteger.TEN).intValue();
    }
}