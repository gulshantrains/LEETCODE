class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length, lastidx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (lastidx != -1 && (i - lastidx - 1) < k)
                    return false;

                lastidx = i;
            }

        }

        return true;
    }
}