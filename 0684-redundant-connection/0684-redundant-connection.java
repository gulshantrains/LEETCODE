class Solution {
    int[] parent; 
    int[] rank; 

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    // Returns false if x and y are already connected (i.e., cycle)
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false; // cycle detected

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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1]; // nodes are 1-based
        rank = new int[n + 1];

        // Initialize DSU: each node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Process each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                // ❌ union failed → cycle formed → this edge is redundant
                return edge;
            }
        }
        return new int[0]; // fallback (should not reach for valid input)
    }
}
