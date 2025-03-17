class Solution {
    public boolean divideArray(int[] nums) {
        int[] ans = new int[1001];

        for (int x : nums)
            ans[x]++;

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0 && ans[i] % 2 != 0)
                return false;
        }
        return true;
    }
}