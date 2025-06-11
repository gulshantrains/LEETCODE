class Solution {
    private boolean dfs(int n, int[][] graph, boolean[] visited, boolean[] inRec) {
        visited[n] = true;
        inRec[n] = true;

        for (int x : graph[n]) {
            if (!visited[x]) {
                if (dfs(x, graph, visited, inRec))
                    return true;
            } else if (inRec[x])
                return true;
        }
        inRec[n] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] inRec = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        // Run cycle detection on all nodes
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, inRec);
            }
        }

        // Nodes marked 2 are safe
        for (int i = 0; i < n; i++) {
            if (!inRec[i]) {
                ans.add(i);
            }
        }

        return ans;

    }
}