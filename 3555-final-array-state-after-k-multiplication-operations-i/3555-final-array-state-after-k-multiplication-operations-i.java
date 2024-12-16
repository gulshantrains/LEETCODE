class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
            int idx=findMin(nums);
            nums[idx]=nums[idx]*multiplier;
        }
        return nums;
    }

    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int findex=-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                findex=i;
            }
        }
     return findex;
    }
}