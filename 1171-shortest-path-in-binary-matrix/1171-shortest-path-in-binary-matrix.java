import java.util.*;

class Solution {

    // 8 directions: up, up-right, right, down-right, down, down-left, left, up-left
    private static final int[][] dir = {
        { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
        { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Base case: blocked start or end
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        // PriorityQueue for Dijkstra: [distance, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 1, 0, 0 }); // Starting point with initial cost = 1

        // Visited matrix to track shortest known path to a cell
        boolean[][] visited = new boolean[n][n];

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int dist = top[0], x = top[1], y = top[2];

            // If already visited, skip
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // Reached destination
            if (x == n - 1 && y == n - 1)
                return dist;

            // Explore all 8 directions
            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];

                // Check bounds and whether cell is clear and unvisited
                if (isValid(newX, newY, n) && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    pq.offer(new int[] { dist + 1, newX, newY });
                }
            }
        }

        // No path found
        return -1;
    }

    // Utility to check if a cell is inside the grid
    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
