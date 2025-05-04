class Solution {
    public int numEquivDominoPairs(int[][] d) {
        int cnt = 0;
        int n = d.length;

        for (int i = 0; i < n - 1; i++) {
            int a = d[i][0];
            int b = d[i][1];
            for (int j = i + 1; j < n; j++) {
                int c = d[j][0];
                int di = d[j][1];

                if (a == c && b == di || a == di && b == c)
                    cnt++;
            }
        }
        return cnt;
    }
}