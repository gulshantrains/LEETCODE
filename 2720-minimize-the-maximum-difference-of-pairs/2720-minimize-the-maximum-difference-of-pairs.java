class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);

        // The answer (minimum maximum difference) can range from 0 to nums[n-1] - nums[0]
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int ans = r; // Initialize ans with the maximum possible difference

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(nums, mid, p)) {
                // If we can form 'p' pairs with max difference 'mid',
                // 'mid' is a possible answer, try for a smaller one.
                ans = mid;
                r = mid - 1;
            } else {
                // If we cannot form 'p' pairs with max difference 'mid',
                // 'mid' is too small, we need a larger max difference.
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int val, int p) {
        int cnt = 0;
        int i = 0;

        while (i < nums.length - 1) {
            // Since nums is sorted, nums[i+1] - nums[i] is equivalent to Math.abs(nums[i] - nums[i+1])
            if (nums[i + 1] - nums[i] <= val) {
                cnt++; // Found a valid pair
                i += 2; // Advance by 2 because both nums[i] and nums[i+1] are used
            } else {
                i++; // Advance by 1 to find the next potential starting element for a pair
            }

            if (cnt >= p) {
                return true;
            }
        }
        return cnt >= p; // Formed at least 'p' pairs
    }
}