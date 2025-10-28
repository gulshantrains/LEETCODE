class Solution {
    public int countValidSelections(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (valid(nums.clone(), i, 1)) ans++;
                if (valid(nums.clone(), i, -1)) ans++;
            }
        }
        return ans;
    }

    public boolean valid(int[] arr, int idx, int dir) {
        int n = arr.length;

        while (idx >= 0 && idx < n) {
            if (arr[idx] == 0) {
                idx += dir;          // <-- move according to current direction
            } else {
                arr[idx]--;          // decrement
                dir = -dir;          // reverse direction
                idx += dir;          // step in new direction
            }
        }

        for (int x : arr) if (x != 0) return false;
        return true;
    }
}
