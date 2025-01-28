class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> qu = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') { // We have found a land
                    qu.offer(new int[] { row, col });// Put cordinate

                    while (!qu.isEmpty()) {
                        int[] cell = qu.poll();
                        int r = cell[0], c = cell[1];

                        if (grid[r][c] == '0')// if it is water then continue
                            continue;

                        grid[r][c] = 0;// mark it as visited

                        // Explore all 4 adjacent cells
                        for (int[] dir : directions) {
                            int newRow = r + dir[0];
                            int newCol = c + dir[1];
        // Basically we are just marking all the connected LAND as visited or ISLAND
                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                                    && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = 0;
                                qu.offer(new int[] { newRow, newCol });
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}