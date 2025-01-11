class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int diSum = 0;
        for (var x : nums) {
            sum += x;
            diSum += digitSum(x);
        }
        return Math.abs(sum - diSum);
    }

    public int digitSum(int x) {
        int digisum = 0;
        while (x > 0) {
            int dig = x % 10;
            digisum += dig;
            x = x / 10;
        }
        return digisum;
    }
}