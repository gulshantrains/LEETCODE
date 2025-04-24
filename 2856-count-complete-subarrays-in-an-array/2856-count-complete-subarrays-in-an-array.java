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
        HashSet<Integer> ch = new HashSet<>();

        for (int i = 0; i < n; i++) {
            ch.clear();

            for (int j = i; j < n; j++) {
                ch.add(nums[j]);
                if (ch.size() == d)
                    ans++;
            }
        }
        return ans;
    }
}