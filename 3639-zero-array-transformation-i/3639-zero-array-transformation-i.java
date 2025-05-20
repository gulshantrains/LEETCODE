class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pre = new int[n + 1];

        for (var x : queries) {
            pre[x[0]] += 1;
            pre[x[1] + 1] -= 1;
        }

        for (int i = 1; i < n + 1; i++) {
            pre[i] += pre[i - 1];
        }
        
        for (int i = 0; i < n; i++) {
            if(nums[i]==0) continue;
            if(nums[i] >pre[i]) return false;
        }
        return true;
    }
}