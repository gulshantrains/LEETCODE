class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long ans=Long.MIN_VALUE;
        long[] pre = new long[n + 1];
        int[] min = new int[n + 1];

        pre[0] = nums[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + nums[i];
        
        min[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--) min[i]=Math.min(min[i+1],nums[i]);

        for(int i=0; i<n-1; i++){
            ans=Math.max(ans, pre[i]-min[i+1]);
        }

        return ans;
    }
}