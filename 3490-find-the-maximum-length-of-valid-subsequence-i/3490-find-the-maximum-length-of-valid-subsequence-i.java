class Solution {
    public int maximumLength(int[] nums) {
        int eve = 0, odd = 0, alternet = 1;
        int paritity = nums[0] % 2;

        for (int x : nums) {
            if (x % 2 == 0)
                eve++;
            else
                odd++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != paritity) {
                alternet++;
                paritity = nums[i] % 2;
            }
        }

        return Math.max(eve, Math.max(odd, alternet));
    }
}