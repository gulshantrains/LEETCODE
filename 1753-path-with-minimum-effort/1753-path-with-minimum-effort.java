class Solution {
    // Check if a cell is within grid bounds
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] h) {
        int l = 0, r = 1_000_001;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (can(h, mid)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public boolean can(int[][] h, int maxVal) {
        int m = h.length;
        int n = h[0].length;

        boolean[][] visit = new boolean[m][n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] { 0, 0, 0 });
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();

            int x = temp[1];
            int y = temp[2];

            for (var d : dir) {
                int nX = x + d[0];
                int nY = y + d[1];

                if (isValid(nX, nY, m, n) && !visit[nX][nY]) {
                    int thres = Math.abs(h[x][y] - h[nX][nY]);
                    if (thres <= maxVal) {
                        pq.offer(new int[] { thres, nX, nY });
                        visit[nX][nY] = true;
                    }
                }
            }
        }
        return visit[m - 1][n - 1];
    }
}