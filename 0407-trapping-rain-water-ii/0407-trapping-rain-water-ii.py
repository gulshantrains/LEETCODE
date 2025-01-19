import heapq

class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        if not heightMap or not heightMap[0]:
            return 0
        
        m, n = len(heightMap), len(heightMap[0])
        min_heap = []
        visited = set()

        # Add boundary cells to the heap
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    heapq.heappush(min_heap, (heightMap[i][j], i, j))
                    visited.add((i, j))

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        water_trapped = 0

        # Process the heap
        while min_heap:
            height, x, y = heapq.heappop(min_heap)

            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited:
                    if heightMap[nx][ny] < height:
                        water_trapped += height - heightMap[nx][ny]
                    heapq.heappush(min_heap, (max(height, heightMap[nx][ny]), nx, ny))
                    visited.add((nx, ny))

        return water_trapped
