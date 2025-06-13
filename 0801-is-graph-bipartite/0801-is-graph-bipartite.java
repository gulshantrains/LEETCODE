class Solution {
    // 0->Not visited 1->Red 2->Green
    public List<List<Integer>> adj;

    public boolean dfs(int n, int[] check, int currcolour) {
        check[n] = currcolour; //Fill with current colour

        int nextcolour = (currcolour == 1) ? 2 : 1; //What should be adjacent colour

        for (int x : adj.get(n)) {
            if (check[x] == 0) { //Not visited earlier kavi v
                if (!dfs(x, check, nextcolour))
                    return false;
            } else if (check[x] == currcolour) //Adjacent Node has same colour no Bipartite
                return false; 
            else if (check[x] == nextcolour) //No issue different colour
                continue;

        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());

            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int n = graph.length;
        int[] check = new int[n];
        Arrays.fill(check, 0);

        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                if (!dfs(i, check, 1))
                    return false;
            }
        }
        return true;
    }
}