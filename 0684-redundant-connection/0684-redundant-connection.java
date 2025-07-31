class Solution {
    int[] parent; // DSU parent array
    int[] rank;   // Rank array for union by rank

    // \U0001f50d FIND with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // compress the path
        }
        return parent[x];
    }

    // \U0001f517 UNION by rank with cycle detection
    // Returns false if x and y are already connected (i.e., cycle)
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false; // cycle detected

        // attach lower rank under higher rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true; // union successful
    }

    // \U0001f3af Main function to find the redundant connection
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1]; // nodes are 1-based
        rank = new int[n + 1];

        // \U0001f6e0 Initialize DSU: each node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // \U0001f9f1 Process each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                // ❌ union failed → cycle formed → this edge is redundant
                return edge;
            }
        }

        return new int[0]; // fallback (should not reach for valid input)
    }
}
