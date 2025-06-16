class Solution {
    private void dfs(char[][] B, int i, int j) {
        if (i >= B.length || j >= B[0].length || i < 0 || j < 0)
            return;
        if (B[i][j] == 'X' || B[i][j] == '*')
            return;

        B[i][j] = '*'; 

        dfs(B, i, j - 1);
        dfs(B, i, j + 1);
        dfs(B, i - 1, j);
        dfs(B, i + 1, j);

    }

    public void solve(char[][] B) {
        if (B == null || B.length == 0 || B[0].length == 0) {
            return;
        }
        int n = B.length; // Number of rows
        int m = B[0].length; // Number of columns

        for (int i = 0; i < m; i++) {
            dfs(B, 0, i);//First row change
            dfs(B, n - 1, i); //Last Row change
        }

        for (int i = 1; i < n - 1; i++) {
            dfs(B, i, 0);
            dfs(B, i, m - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 'O') {
                    B[i][j] = 'X';
                } else if (B[i][j] == '*') {
                    B[i][j] = 'O';
                }
            }
        }

    }
}