class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftMost=leftBS(nums,target);
        int rightMost=rightBS(nums,target);

        return new int[]{leftMost,rightMost};
    }

    private int leftBS(int[] arr, int target){
        int low=0, high=arr.length-1;
        int ans=-1;

        while(low<= high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else 
                low=mid+1;   
        }
        return ans;
    }

    private int rightBS(int[] arr, int target){
        int low=0, high=arr.length-1;
        int anss=-1;

        while(low<= high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                anss=mid;
                low=mid+1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else 
                low=mid+1;
            
        }
        return anss;
    }
}