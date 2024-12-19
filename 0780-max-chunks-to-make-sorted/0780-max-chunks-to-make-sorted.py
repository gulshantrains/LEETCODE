class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        max_till = 0
        chunks = 0

        for i in range(len(arr)):
            max_till = max(max_till, arr[i])

            if max_till == i:
                chunks += 1

        return chunks
