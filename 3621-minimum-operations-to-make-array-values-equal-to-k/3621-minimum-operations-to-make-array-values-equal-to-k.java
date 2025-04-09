class Solution {

    public int secondmax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        for (int num : nums) {
            if (num < max && num > secondMax) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE)
            return max;
        return secondMax;
    }

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        // If any element is less than k, it's impossible to reach k.
        for (int num : nums) {
            if (num < k)
                return -1;
        }

        while (true) {
            boolean allK = true;
            for (int num : nums) {
                if (num != k) {
                    allK = false;
                    break;
                }
            }
            if (allK)
                break;

            boolean uniform = true;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[0]) {
                    uniform = false;
                    break;
                }
            }
            if (uniform) {
                for (int i = 0; i < n; i++) {
                    if (nums[i] > k) {
                        nums[i] = k;
                    }
                }
                ans++;
                continue;
            }

            int smax = secondmax(nums);
            for (int i = 0; i < n; i++) {
                if (nums[i] > smax) {
                    nums[i] = smax;
                }
            }
            ans++;
        }
        return ans;
    }
}
