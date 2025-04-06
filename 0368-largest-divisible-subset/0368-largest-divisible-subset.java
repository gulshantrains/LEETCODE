class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        int maxidx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxidx])
                maxidx = i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = maxidx; i >= 0; i = prev[i]) {
            ans.add(nums[i]);
            if (i == -1)
                break;
        }
        return ans;
    }
}

/*
class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prev = -1;
        Arrays.sort(nums);

        solve(0, nums, result, temp, prev);

        return result;
    }

    public void solve(int idx, int[] nums, List<Integer> result, List<Integer> temp, int prev) {
        //Termination Case
        if (idx >= nums.length) {
            if (result.size() < temp.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        //Take Case
        if (prev == -1 || nums[idx] % prev == 0) {
            temp.add(nums[idx]);
            solve(idx + 1, nums, result, temp, nums[idx]);
            temp.remove(temp.size() - 1);
        }
        //Not Take case
        solve(idx + 1, nums, result, temp, prev);
    }
}
*/
