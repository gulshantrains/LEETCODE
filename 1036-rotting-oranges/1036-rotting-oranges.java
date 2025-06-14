class Solution {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int[] dr = new int[] { 0, 0, -1, 1 }; //It will affect row
    private int[] dc = new int[] { -1, 1, 0, 0 }; //It will affect column

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int good = 0; //Good Oranges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j)); //Fill out all Rotton Oranges
                } else if (grid[i][j] == 1)
                    good++;
            }
        }
        if (good == 0) //No Good oranges already
            return 0;

        int time = 0;
        while (good > 0 && !q.isEmpty()) {

            int s = q.size();
            for (int i = 0; i < s; i++) { //It will Process all batch at once and in Same time frame
                Pair t = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nrow = t.row + dr[d];
                    int ncol = t.col + dc[d];

                    if (nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        good--;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
            time++; //Increase time after processing one batch of queue
        }
        return (good == 0) ? time : -1;
    }
}