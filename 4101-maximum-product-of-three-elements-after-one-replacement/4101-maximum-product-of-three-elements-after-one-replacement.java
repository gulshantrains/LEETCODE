class Solution {
    public long maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int x : nums) {
            x = Math.abs(x);

            if (x > max1) {
                max2 = max1;
                max1 = x;

            } else if (x > max2) {
                max2 = x;
            }
        }

        if (max1 == 0 || max2 == 0)
            return 0L;

        long prod = (long) max1 * max2;

        return prod * 100000;
    }
}
