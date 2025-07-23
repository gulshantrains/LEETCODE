class Solution {

    // Direction array to move in 8 directions: up, up-right, right, down-right, down, down-left, left, up-left
    public int[][] dir = {
            { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
            { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; // Total number of rows
        int n = grid[0].length; // Total number of columns

        // Edge case: start or end cell is blocked, or grid is invalid
        if (m == 0 || n == 0 || grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        // **Breadth-First Search (BFS)** technique is used here
        // WHY BFS? → We are looking for the *shortest path*, and BFS is the standard approach to find shortest path in an unweighted grid
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 }); // Start BFS from the top-left cell (0,0)

        // Mark the starting cell as visited by setting it to 1
        grid[0][0] = 1;

        int level = 0; // level stores the number of steps taken from the start

        // Standard BFS loop
        while (!q.isEmpty()) {
            int N = q.size(); // Number of cells in the current level (distance from source)

            // Explore all cells at the current level
            for (int i = 0; i < N; i++) {
                int[] temp = q.poll(); // Dequeue the cell
                int x = temp[0], y = temp[1];

                // If we've reached the bottom-right cell, return the number of steps
                if (x == m - 1 && y == n - 1)
                    return level + 1; // We add 1 because we started from 0

                // Explore all 8 directions
                for (var d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];

                    // Skip out-of-bound cells or blocked cells (grid[x][y] == 1 means blocked or already visited)
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 1)
                        continue;

                    q.offer(new int[] { newX, newY }); // Add the cell to queue
                    grid[newX][newY] = 1; // Mark cell as visited to prevent re-processing
                }
            }

            // Increment level (distance from start) after processing all nodes in this level
            level++;
        }

        // If BFS finishes and we never reached the bottom-right cell, return -1
        return -1;
    }
}
