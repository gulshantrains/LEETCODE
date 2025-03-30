class Solution {
    public int[] minCosts(int[] cost) {
      int[] ans=new int[cost.length];

      ans[0]=cost[0];
      int x=ans[0];

      for(int i=1; i<cost.length; i++){
        ans[i]=Math.min(x,cost[i]);
        x=Math.min(x,cost[i]);
      }  
      return ans;
    }
}