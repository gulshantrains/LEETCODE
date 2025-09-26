class Solution {

    public int bs(int[] nums, int l, int r, int sum) {
        int ans = l - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;

            if (nums[mid] < sum) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;

            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int k = bs(nums, j + 1, n - 1, sum);

                ans += (k - j);
            }
        }
        return ans;
    }
}