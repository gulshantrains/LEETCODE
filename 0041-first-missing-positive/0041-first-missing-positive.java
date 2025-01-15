class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] and nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // Find the first missing positive
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }

        // If no missing positive is found, return nums.length + 1
        return nums.length + 1;
    }
}
