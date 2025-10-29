class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] per = new boolean[n + 1];
        int[] people = new int[n + 1];

        for (int[] x : trust) {
            per[x[0]] = true;
            people[x[1]]++;

        }

        for (int i = 1; i <= n; i++) {
            if (!per[i] && people[i] == n - 1)
                return i;
        }

        return -1;
    }
}