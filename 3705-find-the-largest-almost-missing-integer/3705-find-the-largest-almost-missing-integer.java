class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++)
                set.add(nums[j]);

            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() == 1 && x.getKey() > ans)
                ans = x.getKey();
        }
        return ans;
    }
}