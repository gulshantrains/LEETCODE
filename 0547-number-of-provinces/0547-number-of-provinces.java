class Solution {
    private static void dfs(int n, boolean[] visited, int[][] M) {
        visited[n] = true; //Visited

        for(int i=0; i<M.length; i++){
            if(!visited[i] && M[n][i]==1){
                dfs(i,visited,M);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int ans = 0; //It will count same province
        int V = M.length; //Total town in city

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans++; //Means a new Province is found because all connected province
                dfs(i, visited, M); //is marked in dfs call
            }
        }
        return ans;
    }
}