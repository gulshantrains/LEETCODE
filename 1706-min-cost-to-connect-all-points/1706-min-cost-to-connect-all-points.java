class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n]; // stores min cost to connect each node
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            // Find the unvisited node with the smallest connection cost
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < min) {
                    min = minDist[j];
                    u = j;
                }
            }

            visited[u] = true;
            totalCost += min;

            // Update connection cost for unvisited neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }

        return totalCost;
    }
}
