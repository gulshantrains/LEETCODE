class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;

        return (n > 0) && ((n & n - 1) == 0) && ((0x55555555 & n) != 0);
    }
}
/*
if (n <= 0)
            return false;

        while (n > 1) {
            if (n % 4 != 0)
                return false;
            n /= 4;
        }
        return n == 1;
*/