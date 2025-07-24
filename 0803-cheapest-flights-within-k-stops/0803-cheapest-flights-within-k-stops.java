import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build the graph using an adjacency list.
        // Each city `u` maps to a list of its outgoing flights `[v, price]`.
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // 2. Use a Priority Queue to always explore the path with the minimum cost first.
        // The state stored is `[cost, city, stops_from_src]`.
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Start the search from the source city with 0 cost and 0 stops.
        pq.offer(new int[]{0, src, 0});

        // =================================================================
        // ## THE TRICKY POINT ##
        // We cannot use a simple `dist[]` array like in a standard Dijkstra's algorithm.
        // A path to a city `v` might be more expensive but use fewer stops,
        // making it a better choice for the overall journey.
        // Therefore, we must track the minimum *stops* to reach a city.
        // This allows us to revisit a city if we find a new path with fewer stops,
        // which a standard `dist[v] = cost` check would incorrectly prevent.
        // =================================================================
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        
        // 3. Main search loop (Dijkstra's Algorithm)
        while (!pq.isEmpty()) {
            // Get the path with the lowest cost from the queue.
            int[] current = pq.poll();
            int cost = current[0];
            int u = current[1];
            int stops = current[2];

            // Pruning: If we've already found a path to city `u` using fewer stops,
            // or if we have exceeded the maximum allowed stops (`k` stops = `k+1` flights),
            // then this path is not worth exploring.
            if (stops > minStops[u] || stops > k + 1) {
                continue;
            }
            
            // Record the minimum stops to reach the current city.
            minStops[u] = stops;

            // If we have reached the destination, this must be the cheapest path.
            // Because the priority queue processes paths in increasing order of cost,
            // the first time we reach the destination, we have found the optimal solution.
            if (u == dst) {
                return cost;
            }

            // 4. Explore neighbors.
            // If we are within the stop limit, add all connecting flights to the queue.
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int price = neighbor[1];
                pq.offer(new int[]{cost + price, v, stops + 1});
            }
        }

        // If the loop finishes and we haven't reached the destination, no such path exists.
        return -1;
    }
}