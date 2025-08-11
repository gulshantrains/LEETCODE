class Solution {
    public int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] Q) {
        int s = Q.length;
        int[] ans = new int[s];

        List<Integer> power = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                power.add(1 << i);
            }
        }
        int idx = 0;
        for (int[] x : Q) {
            int st = x[0], end = x[1];

            long sum = 1;
            for (int i = st; i <= end; i++) {
                sum = (sum * power.get(i)) % MOD;
            }
            ans[idx++] = (int)sum;
        }
        return ans;
    }
}