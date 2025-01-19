import java.util.PriorityQueue;

class Solution {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        // Process cells in priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int k = 0; k < 4; k++) {
                int x = cell.x + dirX[k];
                int y = cell.y + dirY[k];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    // Water trapped depends on the difference between the current height and neighbor height
                    totalWater += Math.max(0, cell.height - heightMap[x][y]);
                    // Update the height of the neighbor to max(cell height, neighbor height)
                    pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                }
            }
        }

        return totalWater;
    }

    // Helper class for the priority queue
    static class Cell {
        int x, y, height;

        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
