class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0

        lmax = [0]*n
        rmax = [0] * n

        lmax[0] = rmax[n - 1] = 0

        # For index 1, the maximum on the left is simply nums[0].
        lmax[1] = nums[0]
        # For index n-2, the maximum on the right is simply nums[n-1].
        rmax[n - 2] = nums[n - 1]

        for i in range(2, n):
            lmax[i] = max(lmax[i - 1], nums[i - 1])

        for i in range(n - 3, -1, -1):
            rmax[i] = max(rmax[i + 1], nums[i + 1])

        ans = 0
        for i in range(1, n - 1):
            candidate = (lmax[i] - nums[i]) * rmax[i]
            ans = max(ans, candidate)

        return ans
