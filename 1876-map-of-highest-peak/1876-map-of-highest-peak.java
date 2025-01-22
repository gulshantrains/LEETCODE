/*--an integer matrix isWater size m x n that represents a map of land and water cells.
--If isWater[i][j] == 0, cell (i, j) is a land cell.
  If isWater[i][j] == 1, cell (i, j) is a water cell.

--The height of each cell must be non-negative.
   -Height should start from 0,1,2...
--If the cell is a water cell, its height must be 0.
--Any two adjacent cells must have an absolute height difference of at most 1.
  -abs(h1-h2)<=1
--A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching)
  -around cell are adjacent 
--find assignment of heights such that the maximum height in the matrix is maximized.
  -???
--Return an integer matrix height of size m x n where height[i][j] is cell (i, j) height
 */

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) { // Water hai iss cell me
                    ans[i][j] = 0; // answer me 0 add kro
                    que.offer(new int[] { i, j }); // ye cordinate ko queue me daal denge for using as SOURCE
                } else {
                    ans[i][j] = -1; // -1 instialize kr denge
                }
            }
        }
        // Direction around (360)
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

        while (!que.isEmpty()) {
            int size = que.size(); // Size of queue

            while (size-- > 0) {
                int[] curr = que.poll();
                int i = curr[0]; // source cordinates hai ye dono {0 wla ke cordinates}
                int j = curr[1];

                for (var dir : directions) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];

                    // Check kr lete hai new i and j safe hai ki nhi and also
                    // ans[i_][j_]==-1 kyu ki we will fill if it is not already assigned
                    if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && ans[i_][j_] == -1) {
                        ans[i_][j_] = ans[i][j] + 1; // Neighbour ko set kr denge +1 kr ke
                        que.offer(new int[] { i_, j_ });
                    }
                }
            }
        }
        return ans;
    }
}