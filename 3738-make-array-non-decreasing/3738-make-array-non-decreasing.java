class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0, prevmax = Integer.MIN_VALUE;

        for (var x : nums) {
            if (x >= prevmax) {
                ans++;
                prevmax = x;
            }
        }
        return ans;
    }
}