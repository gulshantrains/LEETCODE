class Solution {
    public int smallestEqual(int[] nums) {
        int num=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if((i%10==nums[i]) && (num>i)){
                num=i;
            }
        }
        if(num==Integer.MAX_VALUE){
            return -1;
        }
        return num;
    }
}