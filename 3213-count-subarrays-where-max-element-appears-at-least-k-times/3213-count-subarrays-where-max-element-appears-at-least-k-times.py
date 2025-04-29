class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        maxV = max(nums)
        i = ans = temp = 0
        n = len(nums)

        for x in nums:
            if x >= maxV:
                temp += 1
            while temp >= k:
                if nums[i] == maxV:
                    temp -= 1
                i += 1
            ans += i
        return ans
