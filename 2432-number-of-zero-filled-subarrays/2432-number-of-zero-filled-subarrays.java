class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long k = 0;

        for (var x : nums) {
            if (x == 0) {
                k++;
                ans += k;
            } else
                k = 0;
        }
        return ans;
    }
}
/*
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int i = 0, n = nums.length;

        while (i < n) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                long len = (j - i); //Total length of Curr subArray
                ans += (len * (len + 1)) >> 1; //No of SubArray Formed is k*(k+1)/2;
                i = j;
            } else
                i++;

        }
        return ans;
    }
}
*/