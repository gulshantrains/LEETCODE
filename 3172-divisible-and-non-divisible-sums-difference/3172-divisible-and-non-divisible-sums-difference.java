class Solution {
    public int differenceOfSums(int n, int m) {
        int sumD = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0)
                sumD += i;
        }
        return (n * (n + 1)) / 2 - 2 * sumD;
    }
}