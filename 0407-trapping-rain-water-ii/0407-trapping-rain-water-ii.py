class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        import heapq
        if not heightMap or not heightMap[0]:
            return 0

        m, n = len(heightMap), len(heightMap[0])

        # Min-Heap Priority Queue: stores (height, x, y)
        min_heap = []
        visited = set()

        # Add all the boundary cells to the heap
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    heapq.heappush(min_heap, (heightMap[i][j], i, j))
                    visited.add((i, j))

        # Directions for moving up, down, left, right
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        water_trapped = 0

        # Process the heap
        while min_heap:
            height, x, y = heapq.heappop(min_heap)

            # Explore the four neighbors
            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                # Check if the neighbor is within bounds and not visited
                if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited:
                    # Calculate trapped water
                    if heightMap[nx][ny] < height:
                        water_trapped += height - heightMap[nx][ny]

                    # Add the neighbor to the heap with the new height (max of current height and neighbor height)
                    heapq.heappush(min_heap, (max(height, heightMap[nx][ny]), nx, ny))
                    visited.add((nx, ny))

        return water_trapped

        