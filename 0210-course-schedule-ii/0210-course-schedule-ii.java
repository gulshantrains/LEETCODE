class Solution {
    private ArrayList<ArrayList<Integer>> adj; 
    private int[] visit; // Visit state: 0 = unvisited, 1 = visiting, 2 = visited

    private void dfs(int n, Stack<Integer> st, boolean[] vi) {
        vi[n] = true; // Mark current node as visited
        
        for (int v : adj.get(n)) {
            if (!vi[v]) {
                dfs(v, st, vi); // Visit unvisited neighbors
            }
        }
        st.push(n); // Push after visiting all neighbors
    }

    // DFS to detect cycle in the graph
    private boolean isCycle(int n) {
        visit[n] = 1; // Mark as visiting
        for (int x : adj.get(n)) {
            if (visit[x] == 0) {
                if (isCycle(x)) return true; // Cycle found in DFS
            } else if (visit[x] == 1) {
                return true; // Back edge found, cycle exists
            }
        }
        visit[n] = 2; // Mark as visited
        return false;
    }

    public int[] findOrder(int nC, int[][] pre) {
        adj = new ArrayList<>(nC);
        visit = new int[nC];

        // Initialize adjacency list
        for (int i = 0; i < nC; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph: [a, b] means b -> a
        for (int[] e : pre) {
            int course = e[0];
            int prec = e[1];
            adj.get(prec).add(course);
        }

        // Check for cycles in the graph
        for (int i = 0; i < nC; i++) {
            if (visit[i] == 0 && isCycle(i))
                return new int[0]; // Return empty array if cycle found
        }

        Stack<Integer> st = new Stack<>();
        boolean[] vi = new boolean[nC]; // To track visited nodes in DFS

        // Perform DFS to get topological order
        for (int i = 0; i < nC; i++) {
            if (!vi[i])
                dfs(i, st, vi);
        }

        // Build result array from stack
        int[] ans = new int[nC];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }
}
