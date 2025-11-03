class Solution {
    private static final int NOT_GUARDED = 0;
    private static final int GUARDED = 1;
    private static final int WALL = 2;
    private static final int GUARD = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards
        for (int[] g : guards)
            grid[g[0]][g[1]] = GUARD;

        // Mark walls
        for (int[] w : walls)
            grid[w[0]][w[1]] = WALL;

        // Each guard marks in 4 directions
        for (int[] g : guards)
            mark(g[0], g[1], grid);

        // Count unguarded empty cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == NOT_GUARDED)
                    count++;
            }
        }

        return count;
    }

    private void mark(int row, int col, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // up
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) break;
            grid[r][col] = GUARDED;
        }

        // down
        for (int r = row + 1; r < m; r++) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) break;
            grid[r][col] = GUARDED;
        }

        // left
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
            grid[row][c] = GUARDED;
        }

        // right
        for (int c = col + 1; c < n; c++) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
            grid[row][c] = GUARDED;
        }
    }
}
