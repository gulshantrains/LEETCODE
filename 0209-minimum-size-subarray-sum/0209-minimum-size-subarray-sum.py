class Solution:
    def minSubArrayLen(self, t: int, nums: List[int]) -> int:
        n = len(nums)
        i = j = sum_t = 0
        ans = 1000000000

        while j < n:
            sum_t += nums[j]

            while sum_t >= t:
                sum_t -= nums[i]
                ans = min(j - i + 1, ans)
                i += 1
            j += 1

        return 0 if ans == 1000000000 else ans
