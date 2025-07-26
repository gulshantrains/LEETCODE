class Solution {
    public int minCostConnectPoints(int[][] A) {
        int n = A.length, ans = 0;
        boolean[] visit = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //{cost,xi,yi}

        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();

            int cost = temp[0], i = temp[1];

            if (visit[i])
                continue;

            ans += cost;
            visit[i] = true;

            for (int k = 0; k < n; k++) {
                int xj = A[k][0], yj = A[k][1];
                if (!visit[k]) {
                    int manD = Math.abs(A[i][0] - xj) + Math.abs(A[i][1] - yj);

                    pq.offer(new int[] { manD, k });
                }
            }
        }
        return ans;

    }
}