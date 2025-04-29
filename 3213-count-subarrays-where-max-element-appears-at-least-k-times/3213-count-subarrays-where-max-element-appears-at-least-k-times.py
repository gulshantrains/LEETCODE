class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_val = max(nums)
        i = ans = temp = 0
        n = len(nums)

        for j in range(n):
            if nums[j] >= max_val:
                temp += 1
            while temp >= k:
                ans += n - j
                if nums[i] == max_val:
                    temp -= 1
                i += 1

        return ans
