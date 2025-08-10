class Solution {
    public boolean reorderedPowerOf2(int n) {
        long dig = sign(n);

        for (int i = 0; i < 32; i++) {
            if (sign(1 << i) == dig)
                return true;
        }
        return false;
    }

    public long sign(int n) {
        long res = 0;
        for (; n > 0; n /= 10)
            res += (int) Math.pow(10, n % 10);

        return res;
    }
}
/*
c = counter(128)
= 10^8 + 10^2 + 10^1
= 100000110

2^0 = 1        → counter = 10             ≠ 100000110
2^1 = 2        → counter = 100            ≠
...
2^7 = 128      → counter = 100000110  ✅ MATCH
 Return True
*/