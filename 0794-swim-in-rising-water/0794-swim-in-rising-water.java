class Solution {
    class P {
        int x, y, val; // val === timeSoFar = max height along path to (x,y)
        P(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // start with the time equal to the starting cell's height
        pq.offer(new P(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            P curr = pq.poll();
            int x = curr.x, y = curr.y, time = curr.val;

            if (visited[x][y]) continue;

            visited[x][y] = true;

            if (x == n - 1 && y == n - 1) return time;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;

                // propagate the maximum height needed to reach neighbor
                int nextTime = Math.max(time, grid[nx][ny]);
                pq.offer(new P(nx, ny, nextTime));
            }
        }
        return -1; 
    }
}
