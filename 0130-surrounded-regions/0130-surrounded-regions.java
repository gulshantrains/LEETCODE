class Solution {
    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[] dr = new int[] { -1, 1, 0, 0 };
    private int[] dc = new int[] { 0, 0, -1, 1 };

    public void solve(char[][] B) {
        int n = B.length, m = B[0].length;

        Queue<Pair> qu = new LinkedList<>();
        //Mark for 1st Row of Grid
        for (int i = 0; i < m; i++) {
            if (B[0][i] == 'O') {
                B[0][i] = '*';
                qu.add(new Pair(0, i));
            }
        }
        //Mark for Last Row of Grid
        for (int j = 0; j < m; j++) {
            if (B[n - 1][j] == 'O') {
                B[n - 1][j] = '*';
                qu.add(new Pair(n - 1, j));
            }
        }
        for (int i = 0; i < n; i++) {
            if (B[i][0] == 'O') {
                B[i][0] = '*';
                qu.add(new Pair(i, 0));
            }
        }
        for (int i = 0; i < n; i++) {
            if (B[i][m - 1] == 'O') {
                B[i][m - 1] = '*';
                qu.add(new Pair(i, n - 1));
            }
        }

        while (!qu.isEmpty()) {
            Pair temp = qu.poll();

            int row = temp.r;
            int col = temp.c;

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (B[nr][nc] == 'O') {
                        B[nr][nc] = '*';
                        qu.add(new Pair(nr, nc));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == 'O') {
                    B[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == '*') {
                    B[i][j] = 'O';
                }
            }
        }

    }
}