import java.util.*;

public class Solution {

    // 8 directions: vertical, horizontal, and diagonals
    private static final int[][] directions = {
            { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
            { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
    };

    // Main method to find shortest path in binary matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // If start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        // Distance matrix initialized to MAX_VALUE
        int[][] result = new int[m][n];
        for (int[] row : result)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Priority Queue to implement Dijkstra (min-heap based on distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Starting point with distance = 1 (since we start by visiting the first cell)
        pq.offer(new int[] { 1, 0, 0 });
        result[0][0] = 1;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int dist = node[0];
            int x = node[1];
            int y = node[2];

            // Explore all 8 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if cell is clear (0)
                if (isSafe(newX, newY, m, n) && grid[newX][newY] == 0) {
                    // If a shorter path is found
                    if (dist + 1 < result[newX][newY]) {
                        result[newX][newY] = dist + 1;
                        pq.offer(new int[] { dist + 1, newX, newY });
                    }
                }
            }
        }

        return (result[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : result[m - 1][n - 1]);
    }

    // Check if a cell is within grid bounds
    private boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
