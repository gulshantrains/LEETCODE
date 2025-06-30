class Solution {
    public static int[] rank;
    public static int[] parent;

    public int find(int x) {
        if (x == parent[x])
            return x;

        parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);

        if (x_root == y_root)
            return;

        if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else if (rank[y_root] < rank[x_root]) {
            parent[y_root] = x_root;
        } else {
            parent[x_root] = y_root;
            rank[y_root]++;
        }
    }

    public boolean equationsPossible(String[] eq) {
        rank = new int[26];
        parent = new int[26];

        Arrays.fill(rank, 0);
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (var c : eq) {
            if (c.charAt(1) == '=') {
                union(c.charAt(0) - 'a', c.charAt(3) - 'a');
            }
        }
        for (var c : eq) {
            if (c.charAt(1) == '!') {
                int first_par = find(c.charAt(0) - 'a');
                int second_par = find(c.charAt(3) - 'a');

                if (first_par == second_par)
                    return false;
            }
        }
        return true;
    }
}