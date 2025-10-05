class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    int m, n;

    private void dfs(int[][] heights, boolean[][] ocean, int x, int y) {
        ocean[x][y] = true;
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (ocean[nx][ny]) continue; // already visited
            if (heights[nx][ny] < heights[x][y]) continue; // water can only flow from higher/equal
            dfs(heights, ocean, nx, ny);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] paci = new boolean[m][n];
        boolean[][] atla = new boolean[m][n];

        // Pacific borders
        for (int i = 0; i < m; i++) dfs(heights, paci, i, 0);
        for (int j = 0; j < n; j++) dfs(heights, paci, 0, j);

        // Atlantic borders
        for (int i = 0; i < m; i++) dfs(heights, atla, i, n - 1);
        for (int j = 0; j < n; j++) dfs(heights, atla, m - 1, j);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paci[i][j] && atla[i][j]) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }
}
