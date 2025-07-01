class Solution {
    public static int[] parent;
    public static int[] rank;

    public int find(int x) {
        // If x is the parent of itself, then it is the root of this component.
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int x_p = find(x);
        int y_p = find(y);

        if (x_p == y_p)
            return;

        if (rank[x_p] < rank[y_p]) {
            parent[x_p] = y_p;
        } else if (rank[x_p] > rank[y_p]) {
            parent[y_p] = x_p;
        } else {
            parent[x_p] = y_p;
            rank[y_p]++;
        }
    }

    public int makeConnected(int n, int[][] C) {
        parent = new int[n];
        rank = new int[n];

        // Each computer is initially in its own set (its own parent).
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // The rank of each individual node is initially 0.
        Arrays.fill(rank, 0);

        int cable = C.length;

        // To connect 'n' computers (nodes), you need at least 'n-1' cables (edges).
        // If we don't have enough cables, it's impossible to connect everyone.
        if (cable < n - 1)
            return -1;

        // Process all existing connections to form connected components.
        // The union operation will group computers that are already connected.
        for (var x : C) {
            union(x[0], x[1]);
        }

        // After processing all connections, count the number of separate components.
        // A component is identified by its root parent (a node that is its own parent).
        int numberOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                numberOfComponents++;
        }

        // To connect 'k' components, you need 'k-1' new cables.
        // We already confirmed we have enough total cables, answer is the number of components minu - 1.
        return numberOfComponents - 1;
    }
}