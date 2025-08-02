class Solution {
    public int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean can(boolean[][] grid, int x, int y, int m) {

        return (x >= 0 && y >= 0 && x < m && y < m && !grid[x][y]);
    }

    class Tuple {
        int time;
        int x;
        int y;

        Tuple(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

    public int swimInWater(int[][] grid) {
        int m = grid.length; //Row column is also same
        boolean[][] vis = new boolean[m][m];
        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> a.time - b.time);//Min-Heap on time

        pq.offer(new Tuple(grid[0][0], 0, 0));
        vis[0][0] = true;
        int maxTime = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();

            int t = temp.time, xi = temp.x, yi = temp.y;

            
            if (xi == m - 1 && yi == m - 1)
                return t;

            for (var d : dir) {
                int nx = xi + d[0];
                int ny = yi + d[1];

                if (can(vis, nx, ny, m)) {
                    pq.offer(new Tuple(Math.max(t, grid[nx][ny]), nx, ny));
                    vis[nx][ny] = true;
                }

            }
        }
        return -1;
    }
}
/*
MY MISTAKE:
maxTime = Math.min(maxTime, grid[nx][ny])
This minimizes maxTime at every step. However, we actually want to track the 
maximum elevation seen so far on the path, since we must wait until the 
highest elevation on our path is ≤ current time to traverse that path.
*/