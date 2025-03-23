class Solution:
    def maxContainers(self, n: int, w: int, maxWeight: int) -> int:
        if n*n*w < maxWeight:
            return n*n
        return maxWeight//w
        