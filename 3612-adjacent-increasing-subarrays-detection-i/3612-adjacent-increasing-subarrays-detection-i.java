class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] temp = new int[n];
        temp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                temp[i] = (temp[i + 1] + 1);
            } else
                temp[i] = 1;
        }

        for (int i = 0; i <= n - 2 * k; i++) {
            if (temp[i] >= k && temp[i + k] >= k)
                return true;
        }
        return false;
    }
}