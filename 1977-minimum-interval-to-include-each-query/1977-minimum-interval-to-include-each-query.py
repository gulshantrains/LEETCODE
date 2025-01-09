class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        # Sort queries and intervals
        sorted_queries = sorted(queries)
        intervals.sort(key=lambda x: x[0])  # Sort intervals by start point
        
        # Priority queue (min-heap) to store intervals by their size (smallest size first)
        pq = []
        
        # Dictionary to store results for each query
        query_to_result = {}
        i = 0  # Pointer for iterating through intervals
        
        # Process each query in ascending order
        for query in sorted_queries:
            # Add all intervals that start <= current query
            while i < len(intervals) and intervals[i][0] <= query:
                start, end = intervals[i]
                interval_size = end - start + 1
                heapq.heappush(pq, (interval_size, end))  # Push (size, end)
                i += 1
            
            # Remove intervals that end < current query
            while pq and pq[0][1] < query:
                heapq.heappop(pq)
            
            # Store the result for this query
            query_to_result[query] = -1 if not pq else pq[0][0]
        
        # Map results back to the original query order
        return [query_to_result[q] for q in queries]
