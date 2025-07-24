class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    class Pair implements Comparable<Pair> {
        int effort, x, y;

        Pair(int effort, int x, int y) {
            this.effort = effort;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.effort, other.effort);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0, 0));
        effort[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currEff = curr.effort, x = curr.x, y = curr.y;

            if (x == m - 1 && y == n - 1)
                return currEff;

            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextEff = Math.max(currEff, Math.abs(heights[x][y] - heights[nx][ny]));

                    if (nextEff < effort[nx][ny]) {
                        effort[nx][ny] = nextEff;
                        pq.offer(new Pair(nextEff, nx, ny));
                    }
                }
            }
        }
        return 0; // fallback
    }
}
