class Solution {
    public int findMin(int[] nums) {
        int x=nums[BinarySearch(nums)];   

        return x;
    }
    private int BinarySearch(int[] arr){
        int l=0;
        int r=arr.length-1;

        while(l<r){
            int mid=l +(r-l)/2;

            if(arr[mid]>arr[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return r;
    }
}