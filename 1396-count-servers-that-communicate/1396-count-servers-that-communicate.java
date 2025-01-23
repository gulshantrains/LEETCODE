/*---given a map of a server center, represented as a m * n integer matrix grid
--- where 1 means that on that cell there is a server and 0 means that it is no server
---Two servers are said to communicate if they are on the same row or on the same column.
---Return the number of servers that communicate with any other server. */

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sercount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    boolean can = false;
                    // check for server in same row
                    for (int k = 0; k < n; k++) {
                        if (grid[r][k] == 1 && k != c) {
                            can = true;
                            break;
                        }
                    }
                    if (!can) {
                        // now check for server in same column
                        for (int j = 0; j < m; j++) {
                            if (grid[j][c] == 1 && j != r) {
                                can = true;
                                break;
                            }
                        }
                    }
                    if (can)
                        sercount +=1;
                }

            }
        }
        return sercount;
    }
}