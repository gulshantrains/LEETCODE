class Solution {
    public int[] rank;
    public int[] parent;

    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x), py = find(y);

        if (px == py)
            return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public int[] findRedundantConnection(int[][] A) {
        int n = A.length;
        int[] ans = new int[1];

        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (find(A[i][0]) != find(A[i][1])) {
                union(A[i][0], A[i][1]);
            } else
                ans = A[i];
        }
        return ans;
    }
}