class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0, d = 0;

        boolean[] exist = new boolean[2001];
        for (var x : nums) {
            if (!exist[x]) {
                exist[x] = true;
                d++;
            }
        }
        int i = 0, j = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.size() == d) {
                ans += (n - j);
                mp.put(nums[i], mp.get(nums[i]) - 1);

                if (mp.get(nums[i]) <= 0)
                    mp.remove(nums[i]);

                i++;
            }
            j++;
        }
        return ans;
    }
}