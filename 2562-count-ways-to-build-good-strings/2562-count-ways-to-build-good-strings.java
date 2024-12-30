class Solution {
    int L, H, Z, O;
    int M = 100_000_0007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        L = low;
        H = high;
        Z = zero;
        O = one;

        return solve(0, dp);
    }

    public int solve(int length, int[] ar) {
        if (length > H)
            return 0;

        if (ar[length] != -1)
            return ar[length];

        boolean addOne = false;
        if (length >= L && length <= H) {
            addOne = true;
        }

        int take_zero = solve(length + Z, ar);
        int take_one = solve(length + O, ar);

        ar[length] = ((addOne == true ? 1 : 0) + take_zero + take_one) % M;

        return ar[length];
    }
}