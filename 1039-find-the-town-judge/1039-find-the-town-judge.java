class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] t : trust) {
            score[t[0]]--; // trusts someone => lose 1 point
            score[t[1]]++; // trusted by someone => gain 1 point
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1)
                return i;
        }
        return -1;
    }
}