class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int n = grid.length;    // Number of rows
        int m = grid[0].length; // Number of columns

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Traverse left to right for even rows
                for (int j = 0; j < m; j++) {
                    if ((i + j) % 2 == 0) { // Skip every alternate cell
                        result.add(grid[i][j]);
                    }
                }
            } else {
                // Traverse right to left for odd rows
                for (int j = m - 1; j >= 0; j--) {
                    if ((i + j) % 2 == 0) { // Skip every alternate cell
                        result.add(grid[i][j]);
                    }
                }
            }
        }

        return result;
    }
}
