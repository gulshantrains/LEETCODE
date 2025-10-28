class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] freq = new int[50000];
        for (int x : nums)
            freq[x]++;

        int deg = -1, ans = 999_999;
        for (int x : freq)
            deg = Math.max(deg, x);

        for (int i = 0; i < 50000; i++) {
            if (freq[i] == deg) {
                int temp = is(nums, i);

                ans = Math.min(ans, temp);

            }
        }
        return ans;
    }

    public int is(int[] n, int val) {
        int l = -1, r = -1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == val) {
                l = i;
                break;
            }
        }
        for (int i = n.length - 1; i >= 0; i--) {
            if (n[i] == val) {
                r = i;
                break;
            }
        }

        return r - l+1;
    }
}