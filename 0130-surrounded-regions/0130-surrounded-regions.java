import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // Directions for 4-directional movement (up, down, left, right)
    private int[] dr = new int[] { -1, 1, 0, 0 }; 
    private int[] dc = new int[] { 0, 0, -1, 1 }; 

    public void solve(char[][] B) {
        if (B == null || B.length == 0 || B[0].length == 0) {
            return;
        }

        int n = B.length;    // Number of rows
        int m = B[0].length; // Number of columns

        Queue<Pair> qu = new LinkedList<>();

        // Phase 1: Mark 'O's connected to the border using a temporary '*'
        // This ensures these 'O's are not flipped to 'X' later.

        // Iterate through first and last rows to find border 'O's
        for (int i = 0; i < m; i++) {

            // Top row
            if (B[0][i] == 'O') {
                B[0][i] = '*';
                qu.add(new Pair(0, i));
            }
            // Bottom row
            if (B[n - 1][i] == 'O') {
                B[n - 1][i] = '*';
                qu.add(new Pair(n - 1, i));
            }
        }

        // Iterate through first and last columns to find border 'O's
        // Start from 1 and end at n-2 to avoid re-processing corners already handled by row loops
        for (int i = 1; i < n - 1; i++) {

            // Leftmost column
            if (B[i][0] == 'O') {
                B[i][0] = '*';
                qu.add(new Pair(i, 0));
            }
            // Rightmost column
            if (B[i][m - 1] == 'O') {
                B[i][m - 1] = '*';
                qu.add(new Pair(i, m - 1));
            }
        }

        // Phase 2: Perform BFS to mark all 'O's connected to the initially marked border 'O's
        while (!qu.isEmpty()) {
            Pair temp = qu.poll();
            int row = temp.r;
            int col = temp.c;

            // Explore 4-directional neighbors
            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d]; // New row
                int nc = col + dc[d]; // New column

                // Check if the neighbor is within grid boundaries
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    // If neighbor is an 'O' (not yet visited/marked), mark it and add to queue
                    if (B[nr][nc] == 'O') {
                        B[nr][nc] = '*';
                        qu.add(new Pair(nr, nc));
                    }
                }
            }
        }

        // Phase 3: Final transformation of the board
        // Any 'O' remaining is surrounded and becomes 'X'.
        // Any '*' was a border-connected 'O' and reverts to 'O'.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 'O') {
                    // 'O's that were not marked '*' are surrounded and should be captured.
                    B[i][j] = 'X';
                } else if (B[i][j] == '*') {
                    // '*'s were safe 'O's, revert them back.
                    B[i][j] = 'O';
                }
            }
        }
    }
}