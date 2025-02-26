class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=0,minsum=0,currmax=0,currmin=0;

        for(int x: nums){
            currmax=Math.max(x,currmax+x);
            currmin=Math.min(x,currmin+x);

            maxsum=Math.max(maxsum,currmax);
            minsum=Math.min(minsum,currmin);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}