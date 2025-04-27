class Solution {
    public int countSubarrays(int[] nums) {
        int ans=0;
       for(int i=1; i<nums.length-1; i++){
        if((nums[i-1]+nums[i+1])*(1.0)==nums[i]/2.0) ans++;
       } 
       return ans;
    }
}