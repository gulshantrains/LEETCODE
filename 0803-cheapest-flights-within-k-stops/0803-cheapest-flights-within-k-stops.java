class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Priority Queue: [cost, city, stops_from_src]
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        // Use an array to track minimum stops to reach a node
        // This is the correct way to prune in this problem
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minStops[src] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int u = current[1];
            int stops = current[2];

            // If we've already found a shorter path (in terms of stops) to this node, skip
            // Or if we have exceeded the max stops limit
            if (stops > minStops[u] || stops > k + 1) {
                continue;
            }
            
            // Update min stops to reach this node
            minStops[u] = stops;

            if (u == dst) {
                return cost;
            }

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int price = neighbor[1];
                pq.offer(new int[]{cost + price, v, stops + 1});
            }
        }

        return -1;
    }
}