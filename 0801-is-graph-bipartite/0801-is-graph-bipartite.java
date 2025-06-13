class Solution {
    public boolean dfs(int n, int currcolor, int[] colour, int[][] graph) {
        colour[n] = currcolor;
        int ncolor = (currcolor == 0) ? 1 : 0;

        for (int x : graph[n]) {
            if (colour[x] == -1) { // Case 1: Neighbor is unvisited
                if (!dfs(x, ncolor, colour, graph)) { // Recurse with alternate color
                    return false; // Propagate conflict
                }
            } else if (colour[x] == currcolor) { // Case 2: Neighbor is visited AND has the SAME color
                // This is the critical check for non-bipartiteness (odd-length cycle)
                return false; // Conflict found
            }
            // Case 3: Neighbor is visited and has the DIFFERENT color (colour[x] == ncolor). This is valid.
        }
        return true; // No conflict found in this branch
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1); // Initialize all nodes as unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // If the node hasn't been visited (start of a new component)
                if (!dfs(i, 0, color, graph)) { // Start DFS with color 0
                    return false; // If DFS returns false, a conflict was found
                }
            }
        }
        return true; // If all components are successfully colored, the graph is bipartite
    }
}