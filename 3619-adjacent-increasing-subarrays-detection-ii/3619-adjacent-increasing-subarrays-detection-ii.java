class Solution {
    public int maxIncreasingSubarrays(List<Integer> A) {
        int n = A.size(), ans = 0, cur = 1, precur = 0;

        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i - 1)) {
                cur++;
            } else {
                precur = cur;
                cur = 1;
            }
            //run length = 6 then two subarrays of length 3
            ans = Math.max(ans, Math.max(cur / 2, Math.min(precur, cur)));
        }
        return ans;
    }
}