class Solution {
    public int find(int[] a, int n) {
        if (n == 1)
            return a[0];

        for (int i = 0; i < n - 1; i++) {
            a[i] = (a[i] + a[i + 1]) % 10;
        }
        return find(a, n - 1);
    }

    public int triangularSum(int[] nums) {
        return find(nums, nums.length);
    }
}
/*
public int triangularSum(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];

        while (len > 1) {
            for (int i = 0; i < len - 1; i++) {

                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            len--;
        }
        return nums[0];
    }
*/