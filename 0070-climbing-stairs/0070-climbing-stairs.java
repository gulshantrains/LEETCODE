class Solution {
    public int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        if(n<=3) return n;


        return solve(n);
    }
    public int solve(int n){
        if(n<=3) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n]=solve(n-1)+solve(n-2);
    }
}
/*
Recursion--->O(2^n)
class Solution {
    public int climbStairs(int n) {
      if(n<=3) return n;

      return climbStairs(n-1)+climbStairs(n-2);
    }
}
*/
