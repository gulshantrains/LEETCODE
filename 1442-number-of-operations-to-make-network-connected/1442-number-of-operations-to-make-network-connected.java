class Solution {
    private int[] parent;
    private int[] rank;
    private int cableCount; // ✅ Directly track the number of components.

    public int makeConnected(int n, int[][] connections) {
        // To connect 'n' computers, you need at least 'n-1' cables.
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];
        cableCount = n; // Start with n separate components.

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // --- Union Operations ---
        // Process all existing connections to merge components.
        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        // The number of operations needed is the number of components minus one.
        return cableCount - 1;
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    /**
     * Merges the sets containing x and y using union by rank.
     */
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            cableCount--; // ✅ Decrement count upon successful merge.
        }
    }
}