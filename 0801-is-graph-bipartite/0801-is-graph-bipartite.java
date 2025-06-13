class Solution {
    public boolean dfs(int n, int currcolor, int[] colour, int[][] graph) {
        colour[n] = currcolor;
        int ncolor = (currcolor == 0) ? 1 : 0;

        for (int x : graph[n]) {
            if (colour[x] == -1) {
                if (!dfs(x, ncolor, colour, graph))
                    return false;
            } else if (colour[x] == currcolor)
                return false;

        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph))
                    return false;
            }
        }
        return true;
    }
}