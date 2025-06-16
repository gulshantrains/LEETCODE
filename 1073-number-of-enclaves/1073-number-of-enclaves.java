class Solution {
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1)
                    dfs(grid, i, j);
            }
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
        // return Arrays.stream(grid).mapToInt(row-> Arrays.stream(row).sum()).sum();
    }
}