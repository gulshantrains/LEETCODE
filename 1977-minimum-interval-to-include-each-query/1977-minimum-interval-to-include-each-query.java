import java.util.*;

class Solution {
    public int[] minInterval(int[][] A, int[] queries) {
        int n = queries.length, m = A.length;
        // Clone queries for sorting and create result array
        int[] sortedQueries = queries.clone(), result = new int[n];
        Arrays.sort(sortedQueries); // Sort queries
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0])); // Sort intervals by start point

        // Priority queue to store intervals by their size (smallest size first)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Map to store results for each query
        Map<Integer, Integer> queryToResult = new HashMap<>();
        int i = 0; // Pointer for iterating through intervals

        // Process each query in ascending order
        for (int query : sortedQueries) {
            // Add all intervals that start <= current query
            while (i < m && A[i][0] <= query) {
                int start = A[i][0], end = A[i][1];
                pq.offer(new int[] { end - start + 1, end }); // {size, end}
                i++;
            }

            // Remove intervals that end < current query
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            // Store the result for this query
            queryToResult.put(query, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        // Map results back to original query order
        for (int j = 0; j < n; j++) {
            result[j] = queryToResult.get(queries[j]);
        }

        return result;
    }
}
