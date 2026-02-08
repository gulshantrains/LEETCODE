class Solution {
    public int dominantIndices(int[] nums) {
       int ans=0,n=nums.length;
       double sum=0;
       for(int x: nums) sum+=x;

       for(int i=0; i<n-1; i++){
        sum-=nums[i];
        double avg=(sum)/(n-i-1);

        if(nums[i] > avg) ans++;
       } 

       return ans;
    }
}