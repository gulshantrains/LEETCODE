class Solution {
    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i <= n; i++) {
            int a = i, b = n - i;

            String as = String.valueOf(a);
            String bs = String.valueOf(b);

            if (!as.contains("0") && !bs.contains("0")) {

                return new int[] { a, b };
            }
        }
        return new int[] { 0, 0 };
        //return (n % 2 == 0 ? new int[] { 1, n - 1 } : new int[] { 2, n - 2 });
    }
}