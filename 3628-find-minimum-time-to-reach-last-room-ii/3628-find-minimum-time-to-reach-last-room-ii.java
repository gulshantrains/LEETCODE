class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        long[][][] minTime = new long[n][m][2];
        for (var plane : minTime) {
            for (var row : plane) {
                Arrays.fill(row, Long.MAX_VALUE);
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        minTime[0][0][0] = 0;
        pq.offer(new long[] { 0, 0, 0, 0 });

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currentTime = current[0];
            int r = (int) current[1];
            int c = (int) current[2];
            int currentParity = (int) current[3];

            if (currentTime > minTime[r][c][currentParity]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return (int) currentTime;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    long moveCost = (currentParity == 0) ? 1 : 2;

                    long earliestStartTime = Math.max(currentTime, moveTime[nr][nc]);

                    long newTime = earliestStartTime + moveCost;

                    int nextParity = 1 - currentParity;

                    if (newTime < minTime[nr][nc][nextParity]) {
                        minTime[nr][nc][nextParity] = newTime;
                        pq.offer(new long[] { newTime, nr, nc, nextParity });
                    }
                }
            }
        }

        return -1;
    }
}
