class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        i = cnt = temp = 0

        for j in range(len(nums)):
            temp += nums[j]

            while temp * (j - i + 1) >= k:
                temp -= nums[i]
                i += 1

            cnt += j - i + 1
        return cnt
