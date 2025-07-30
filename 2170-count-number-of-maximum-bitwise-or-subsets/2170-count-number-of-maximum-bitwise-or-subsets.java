class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int x : nums)
            maxOr |= x;

        int n = nums.length;

        int total = 1 << n; //Total number of SubSet (2^n)
        int ans = 0;

        for (int mask = 0; mask < total; mask++) {
            int currOr = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) { //This bascially check we should include curr element or not if 0 dont if 1 yes 
                    currOr |= nums[i];
                }

            }
            if (currOr == maxOr)
                ans++;
        }
        return ans;
    }
}