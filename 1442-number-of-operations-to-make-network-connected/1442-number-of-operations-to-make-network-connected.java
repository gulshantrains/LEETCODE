class Solution {
    public static int[] parent;
    public static int[] rank;

    public int find(int x) {
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

        Arrays.fill(rank, 0);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int cable = C.length;

        if (cable + 1 < n) //We dont have minimum enough cable
            return -1;

        int ans = 0;

        for (var x : C) {
            union(x[0], x[1]);
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                ans++;
        }
        return ans - 1;
    }
}