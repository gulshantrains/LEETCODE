class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int x : nums) {
            sum2 += x;
            if (x < 10) {
                sum1 += x;
            }
        }
        sum2 -= sum1;
        return (sum2 == sum1) ? false: true;
    }
}