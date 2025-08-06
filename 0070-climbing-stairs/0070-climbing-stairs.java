class Solution {

    public int climbStairs(int n) {
        if(n<=3) return n;

        int a = 1, b = 2;
        int c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;

        }
        return b;
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
Memoization---->O(n)
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
*/
