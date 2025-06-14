class Solution {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int[] dir = new int[] { -1, 0, 1, 0, -1 };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int good = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1)
                    good++;
            }
        }
        if (good == 0)
            return 0;

        int time = 0;
        while (!q.isEmpty()) {

            int s = q.size();
            boolean flag = false;
            for (int i = 0; i < s; i++) {
                Pair t = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nrow = t.row + dir[d];
                    int ncol = t.col + dir[d + 1];

                    if (nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        good--;
                        q.offer(new Pair(nrow, ncol));
                        flag = true;
                    }
                }
            }
            if (flag)
                time++;
        }
        return (good == 0) ? time : -1;
    }
}