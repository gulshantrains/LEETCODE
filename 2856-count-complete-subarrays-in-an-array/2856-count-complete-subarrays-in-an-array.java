class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : nums)
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int d = mp.size(); //Total Distinct element

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> temp = new HashMap<>(); // fresh map for each i
            for (int j = i; j < n; j++) {
                temp.put(nums[j], temp.getOrDefault(nums[j], 0) + 1);
                if (temp.size() == d)
                    ans++;
                else if (temp.size() > d)
                    break; // no need to continue if distinct count exceeded
            }
        }
        return ans;
    }
}