class Solution {
    public long removeZeros(long n) {
        StringBuilder ans = new StringBuilder();

        while (n != 0) {
            long rem = n % 10;
            if (rem != 0)
                ans.append(rem);
            n /= 10;
        }
        long x = Long.valueOf(ans.reverse().toString());

        return x;
    }
}