import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    // Class to represent a state in the priority queue
    class State {
        long time;
        int row;
        int col;

        public State(long time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        if (moveTime[0][1] > 1 && moveTime[1][0] > 1) {

        }

        // minTime[i][j] stores the minimum time to arrive at room (i, j)
        long[][] minTime = new long[n][m];
        for (long[] row : minTime) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // Priority queue to store states (time, row, col), ordered by time
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));

        // Start at (0, 0) at time 0
        minTime[0][0] = 0;
        pq.offer(new State(0, 0, 0));

        // Directions for moving to adjacent rooms (up, down, left, right)
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!pq.isEmpty()) {
            State current = pq.poll();
            long currentTime = current.time;
            int r = current.row;
            int c = current.col;

            // If we already found a shorter path to this room, skip
            if (currentTime > minTime[r][c]) {
                continue;
            }

            // If we reached the destination room, return the time
            if (r == n - 1 && c == m - 1) {
                return (int) currentTime; // Cast to int as the problem asks for int output
            }

            // Explore adjacent rooms
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check boundary conditions
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    long newTime = Math.max(currentTime, moveTime[nr][nc]) + 1;

                    if (newTime < minTime[nr][nc]) {
                        minTime[nr][nc] = newTime;
                        pq.offer(new State(newTime, nr, nc));
                    }
                }
            }
        }
        return -1; // Indicate unreachable, though problem implies reachability
    }
}
