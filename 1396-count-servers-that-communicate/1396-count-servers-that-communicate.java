/*---given a map of a server center, represented as a m * n integer matrix grid
--- where 1 means that on that cell there is a server and 0 means that it is no server
---Two servers are said to communicate if they are on the same row or on the same column.
---Return the number of servers that communicate with any other server. */


//TC->O(m*n)+O(m*n)
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[] rowcnt = new int[m];
        int[] colmcnt = new int[n];
        Arrays.fill(rowcnt, 0);
        Arrays.fill(colmcnt, 0);
        // Row array and column array me kitne server hai usse store kr lete hai
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    rowcnt[r]++;
                    colmcnt[c]++;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
               //The loop that calculates the final count checks whether a server is located at (r, c) 
               //..and can communicate with others (i.e., rowcnt[r] > 1 || colmcnt[c] > 1).
                if (grid[r][c] == 1 && (rowcnt[r] > 1 || colmcnt[c] > 1))
                    count++;
            }
        }
        return count;
    }
}