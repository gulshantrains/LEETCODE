class Solution {
    private int[] helper (int node, int parent, Map<Integer, List<Integer>> adj, int[] values, int k) {
        int[] res = new int[] {0, values[node]%k};
        
        for (int child: adj.get(node)) {
            if (child == parent) continue;

            int[] childRes = helper(child, node, adj, values, k);
            res[0] += childRes[0];
            res[1] += childRes[1];
            res[1] %= k;
        }

        if (res[1] == 0) {
            res[0] += 1;
        }
        return res;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i += 1) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i += 1) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int node = 0; node < n; node += 1) {
            if (adj.get(node).size() <= 1) {
                return helper(node, -1, adj, values, k)[0];
            }
        }
        return 0;
    }
}