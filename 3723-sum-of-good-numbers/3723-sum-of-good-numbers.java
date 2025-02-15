class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
//If i-k is true then second case does not matter && if i+k is also true means we dont have valid index ...so TRUE && TRUE = TRUE so add in sum
//if i-k is false means one valid index exist then check for nums[i-k] if this is true then check for i+k if also false means both valid index exist then its COMPULSORY for nums[i]>>>

        for (int i = 0; i < n; i++) {
            if ((i - k < 0 || nums[i] > nums[i - k]) &&
                    (i + k >= nums.length || nums[i] > nums[i + k]))
                sum += nums[i];
        }
        return sum;
    }
}
