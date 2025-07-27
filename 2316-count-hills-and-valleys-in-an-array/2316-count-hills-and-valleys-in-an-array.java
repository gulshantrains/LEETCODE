class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            // Skip if nums[i] == nums[i - 1]
            if (nums[i] == nums[i - 1]) continue;

            int left = i - 1;
            int right = i + 1;

            // Skip over equal elements to the left
            while (left >= 0 && nums[left] == nums[i]) left--;

            // Skip over equal elements to the right
            while (right < n && nums[right] == nums[i]) right++;

            // Must have valid neighbors
            if (left >= 0 && right < n) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    ans++; // Hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    ans++; // Valley
                }
            }
        }

        return ans;
    }
}
