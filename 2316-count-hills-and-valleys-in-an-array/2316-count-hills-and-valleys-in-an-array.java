class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        // Step 1: Remove consecutive duplicates
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                temp.add(nums[i]);
            }
        }

        // Step 2: Count hills and valleys
        int count = 0;
        for (int i = 1; i < temp.size() - 1; i++) {
            int prev = temp.get(i - 1);
            int curr = temp.get(i);
            int next = temp.get(i + 1);

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                count++;
            }
        }

        return count;
    }
}
