class Solution {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length <= 2) //If length of Array is <=2 then simpley return
            return nums.length;

        int maxL = 2; //Minimum value of length

        int[][] dp = new int[1001][1000]; //Max diff is <=500 so Row is this and Column is 1000

        for (int[] x : dp)
            Arrays.fill(x, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j]; //This is difference
                int diffidx = 500 + diff; //This 500 will work as offset for negative value ie -2-->498 index

                dp[diffidx][i] = dp[diffidx][j] + 1;

                maxL = Math.max(maxL, dp[diffidx][i]);
            }
        }
        return maxL;

    }
}