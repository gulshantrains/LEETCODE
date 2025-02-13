class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        map = {0: -1}
        sum = 0

        for i, n in enumerate(nums):
            sum += n
            r = sum % k

            if r not in map:
                map[r] = i
            elif i - map[r] > 1:
                return True

        return False
