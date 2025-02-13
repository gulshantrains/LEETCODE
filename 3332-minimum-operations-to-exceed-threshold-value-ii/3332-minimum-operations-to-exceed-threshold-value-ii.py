class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        ans = 0

        while nums[0] < k:
            s1 = heapq.heappop(nums)
            s2 = heapq.heappop(nums)

            heapq.heappush(nums,s1 * 2 + s2)
            ans += 1

        return ans
