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
            if (parent[i] == i) { // If 'i' is a root of a component
                long currentSize = Size[i];
                ans += currentSize * (totalRemainingNodes - currentSize);
                totalRemainingNodes -= currentSize;
            }
        }
        return ans;
    }
}