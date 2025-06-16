class Solution {
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        if (grid[i][j] == 0)
            return;

        grid[i][j] = 0;

        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length; //Row
        int m = grid[0].length; //Column

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1)
                dfs(grid, 0, i); //First Row 

            if (grid[n - 1][i] == 1)
                dfs(grid, n - 1, i); //Last Row
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0); //First column

            if (grid[i][m - 1] == 1) //Last column
                dfs(grid, i, m - 1);
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }
}