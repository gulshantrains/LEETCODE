class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {index, cost}
        pq.offer(new int[]{0, 0}); // Start from point 0 with 0 cost

        int totalCost = 0;
        int connectedPoints = 0;

        while (!pq.isEmpty() && connectedPoints < n) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            totalCost += cost;
            connectedPoints++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[node][0] - points[i][0]) +
                               Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new int[]{i, dist});
                }
            }
        }

        return totalCost;
    }
}