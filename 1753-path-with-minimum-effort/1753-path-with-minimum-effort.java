import java.util.*;

class Solution {
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        int low = 0, high = 1_000_000, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(heights, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canReach(int[][] heights, int maxEffort) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            if (x == m - 1 && y == n - 1) return true;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (isValid(nx, ny, m, n) && !visited[nx][ny]) {
                    int diff = Math.abs(heights[x][y] - heights[nx][ny]);
                    if (diff <= maxEffort) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }

        return false;
    }
}
