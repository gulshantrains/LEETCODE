class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[nums.length];
        int[] ans = new int[2];
        int idx=0;

        for (int n : nums)
            freq[n]++;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}