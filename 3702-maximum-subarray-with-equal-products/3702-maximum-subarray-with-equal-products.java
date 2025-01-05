class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long gcdV = nums[i], lcmV = nums[i], prodV = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                gcdV = gcd(gcdV, nums[j]);
                prodV *= (long) nums[j];
                lcmV = lcm(lcmV, (long) nums[j]);

                if (prodV == gcdV * lcmV) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}