class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0, prevmax = 0;

        for (var x : nums) {
            if (x >= prevmax) {
                ans++;
                prevmax = x;
            }
        }
        return ans;
    }
}