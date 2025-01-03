class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> ls = new ArrayList<>();

                for (int k = 0; k < n; k++) {
                    if (k < i || k > j) {
                        ls.add(nums[k]);
                    }
                }
                if (isStrictlyinc(ls))
                    count++;

            }
        }
        return count;
    }

    public boolean isStrictlyinc(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1))
                return false;
        }
        return true;
    }
}