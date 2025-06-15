import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class P {
        int row, col;

        P(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int[] dr = new int[] { 0, 0, -1, 1 };
    private int[] dc = new int[] { -1, 1, 0, 0 };

    public int[][] floodFill(int[][] mat, int sr, int sc, int color) {

        int n = mat.length;
        int m = mat[0].length;

        int target = mat[sr][sc]; // The original color of the starting cell

        // If the target color is already the new color, no fill is needed.
        // This also handles cases where we might infinitely loop if target == color
        // and we don't track visited.
        if (target == color) {
            return mat;
        }

        Queue<P> qu = new LinkedList<>();

        qu.offer(new P(sr, sc));
        mat[sr][sc] = color; // Change the color in the original matrix and mark as visited

        while (!qu.isEmpty()) {
            P temp = qu.poll();
            int r = temp.row;
            int c = temp.col;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // Only process if the neighbor has the target color
                    // (which means it hasn't been visited/changed yet)
                    if (mat[nr][nc] == target) {
                        mat[nr][nc] = color; // Change its color
                        qu.offer(new P(nr, nc)); // Add to queue for further processing
                    }
                }
            }
        }

        return mat; // Return the modified matrix
    }
}