class Solution {
    public int[] parent;
    public int[] Size;

    // Find operation with path compression
    private int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    // Union operation with union by size (as it now stores size)
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        // Union by size: attach smaller component to larger component
        if (Size[rootX] < Size[rootY]) {
            parent[rootX] = rootY;
            Size[rootY] += Size[rootX];
        } else { // Size[rootX] >= Size[rootY]
            parent[rootY] = rootX;
            Size[rootX] += Size[rootY];
        }
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        Size = new int[n];

        // Initialize: each node is its own parent, and each component initially has size 1
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            Size[i] = 1; // Initialize size to 1 for each individual node
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        long totalRemainingNodes = n; // Total nodes remaining to be paired
        long ans = 0;

        // Iterate through all nodes to find component roots and calculate pairs
        for (int i = 0; i < n; i++) {
            // If parent[i] == i, it means i is the root (representative) of a connected component.
            // We only process each component once, via its root.
            if (parent[i] == i) {
                long currentComponentSize = Size[i]; // Get the size of the current component.

                // The number of unconnected pairs involving nodes in the 'currentComponent'
                // is (size of currentComponent) * (sum of sizes of all other components).
                // 'totalRemainingNodes' represents the sum of sizes of all components
                // that have not yet been processed (including the current one).
                ans += currentComponentSize * (totalRemainingNodes - currentComponentSize);

                // After processing the current component, subtract its size from
                // 'totalRemainingNodes' so it's not counted in future iterations.
                totalRemainingNodes -= currentComponentSize;
            }
        }
        // The formula 'size * (totalRemainingNodes - size)' effectively counts each
        // pair (node from component A, node from component B) exactly once
        // (when component A is processed, it considers pairs with all subsequent components).
        // If we sum (size_A * (N - size_A)) for all A, where N is the total,
        // it would count A-B and B-A.
        // However, by decrementing totalRemainingNodes, we avoid double counting:
        // First component: size1 * (n - size1)
        // Second component: size2 * ((n - size1) - size2)
        // ... and so on. This correctly calculates the total number of unique unconnected pairs.
        return ans;
    }
}