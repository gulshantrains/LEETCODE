class Solution {
    private static final int EMPTY = 0, GUARDED = 1, WALL = 2, GUARD = 3;
    private static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards and walls
        for (int[] g : guards) grid[g[0]][g[1]] = GUARD;
        for (int[] w : walls) grid[w[0]][w[1]] = WALL;

        // Spread guard vision
        for (int[] g : guards)
            for (int[] d : DIRS)
                mark(g[0], g[1], d, grid);

        // Count unguarded cells
        int unguarded = 0;
        for (int[] row : grid)
            for (int cell : row)
                if (cell == EMPTY) unguarded++;

        return unguarded;
    }

    private void mark(int r, int c, int[] dir, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        r += dir[0];
        c += dir[1];
        while (r >= 0 && r < m && c >= 0 && c < n) {
            if (grid[r][c] == WALL || grid[r][c] == GUARD) break;
            grid[r][c] = GUARDED;
            r += dir[0];
            c += dir[1];
        }
    }
}
