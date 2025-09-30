class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        long ans = 0;
        if (n == 1)
            return nums[0];

        int[] coeF = new int[n];
        coeF[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= 1; j--) {

                coeF[j] = (coeF[j - 1] + coeF[j]) % 10;
            }
        }
        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * coeF[i]) % 10;
        }
        return (int) ans;
    }
}