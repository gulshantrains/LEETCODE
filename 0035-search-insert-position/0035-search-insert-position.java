class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int ans=0;

        while(low <= high){
            int mid=low +(high-low)/2;

            if(nums[mid]==target) return mid;

            if(target>nums[mid]){
                ans=mid+1;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}