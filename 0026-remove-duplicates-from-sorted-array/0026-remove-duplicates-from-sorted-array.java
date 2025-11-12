class Solution {
    public int removeDuplicates(int[] nums) {
       int n=nums.length,k=0,ans=0;

       for(int i=1; i<n; i++){
        if(nums[i] != nums[i-1]){
            nums[k++]=nums[i-1];
            ans++;
        }
       }
       nums[k]=nums[n-1];

       return ans+1;
    }
}