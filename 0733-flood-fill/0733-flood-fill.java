class Solution {
    private int[] dr = new int[] { 0, 0, -1, 1 };
    private int[] dc = new int[] { -1, 1, 0, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc]; //This is the target to check neighbour node

        if (target == color)
            return image;

        dfs(image, sr, sc, target, color);

        return image;
    }

    private void dfs(int[][] im, int sr, int sc, int target, int color) {
        if (sr < 0 || sc < 0 || sr >= im.length || sc >= im[0].length)
            return;

        if (im[sr][sc] != target)
            return;

        im[sr][sc] = color;

        for (int d = 0; d < 4; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            dfs(im, nr, nc, target, color);
        }
    }
}