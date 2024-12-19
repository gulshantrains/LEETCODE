class Solution {
     boolean[] check = new boolean[1001];
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        seive(1000);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                continue;

            for (int j = 2; j < nums[i]; j++) {
                if (!check[j])
                    continue;

                if (nums[i] - j < nums[i + 1]) {
                    nums[i] -= j;
                    break;
                }
            }
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;

    }

    public void seive(int n) {
        Arrays.fill(check, true);

        check[0] = false;
        check[1] = false;
        for (int i = 2; i < n; i++) {
            if (check[i]) {
                for (int j = i * i; j < n; j += i) {
                    check[j] = false;
                }
            }
        }
    }
}