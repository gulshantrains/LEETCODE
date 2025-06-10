class Solution {
    private static void dfs(int n, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[n] = true; //Visited

        for (int v : adj.get(n)) {

            if (!visited[v]) {
                dfs(v, visited, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0; //It will count same province
        int V = isConnected.length; //Total town in city
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    continue;

                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans++; //Means a new Province is found
                dfs(i, visited, adj);
            }
        }
        return ans;
    }
}