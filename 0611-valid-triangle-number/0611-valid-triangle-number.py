class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        ans, n = 0, len(nums)

        for k in range(n - 1, 1, -1):
            i, j = 0, k - 1

            # try all pairs (i, j) with this k
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    # all pairs from i..j-1 with j also valid
                    ans += (j - i)
                    j -= 1
                else:
                    i += 1

        return ans
        