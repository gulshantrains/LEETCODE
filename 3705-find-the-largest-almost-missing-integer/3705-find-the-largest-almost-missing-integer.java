class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(k==nums.length){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }

        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++)
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() == 1)
                ans = Math.max(x.getKey(), ans);
        }
        return ans;
    }
}