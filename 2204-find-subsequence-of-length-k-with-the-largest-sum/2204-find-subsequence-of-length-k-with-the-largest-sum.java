class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairr = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairr[i][0] = nums[i];
            pairr[i][1] = i;
        }
        Arrays.sort(pairr, (a, b) -> b[0] - a[0]);

        int[][] an = Arrays.copyOfRange(pairr, 0, k);

        Arrays.sort(an, (a, b) -> a[1] - b[1]);

        int[] res = new int[k];
        int j = 0;
        for (var x : an) {
            res[j++] = x[0];
        }
        return res;
    }
}