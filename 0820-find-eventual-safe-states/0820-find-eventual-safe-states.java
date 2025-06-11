class Solution {
    private List<List<Integer>> adj;
    private int[] visit; //[ 0: Not Visited ][ 1:Being visited ] [ 2:Visited (Done) ]

    private boolean isCycle(int n) {
        visit[n] = 1;

        for (int x : adj.get(n)) {
            if (visit[x] == 0 && isCycle(x)) {
                return true;
            } else if (visit[x] == 1) {
                return true; //Node is visited and this is Back Edge also
            }
        }
        visit[n] = 2;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        adj = new ArrayList<>(n);
        visit = new int[n];
        Arrays.fill(visit, 0);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);

            }
        }

        // Run cycle detection on all nodes
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                isCycle(i);
            }
        }

        // Nodes marked 2 are safe
        for (int i = 0; i < n; i++) {
            if (visit[i] == 2) {
                ans.add(i);
            }
        }

        return ans;

    }
}