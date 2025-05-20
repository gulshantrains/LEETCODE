class Solution {
    public boolean isZeroArray(int[] nums, int[][] qr) {
        int n = nums.length;
        int[] dif = new int[n + 1];

        for (var x : qr) {
            dif[x[0]]++;
            dif[x[1] + 1]--;
        }
        for(int i=0; i<n; i++){
            dif[i+1] +=dif[i];
        }
        for(int i=0; i<n; i++){
            if(dif[i] == nums[i]) continue;
            if(nums[i]==0) continue;
            if(dif[i]>nums[i]) continue;
            if(dif[i]<nums[i]) return false;
        }
        return true;
    }
}