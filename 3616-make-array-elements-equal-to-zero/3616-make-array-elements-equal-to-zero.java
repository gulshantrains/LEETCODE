class Solution {
    public int countValidSelections(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

                if (valid(nums.clone(), i, 1))
                    ans++;
                if (valid(nums.clone(), i, -1))
                    ans++;
            }
        }
        return ans;

    }

    public boolean valid(int[] arr, int idx, int dir) {
        int n = arr.length;

        while (idx >= 0 && idx < n) {
            if (arr[idx] == 0) {
                idx+=dir;
            } else {
                arr[idx]--;
                dir = -dir;
                idx += dir;

            }
        }
        return Arrays.stream(arr).sum() == 0;
    }
}