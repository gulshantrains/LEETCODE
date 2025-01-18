class Solution {
    private int subArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, cnt = 0, j = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() > k) {
                map.put(nums[j], map.get(nums[j]) - 1);

                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            cnt += (i - j + 1);
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums, k) - subArray(nums, k - 1);
    }
}