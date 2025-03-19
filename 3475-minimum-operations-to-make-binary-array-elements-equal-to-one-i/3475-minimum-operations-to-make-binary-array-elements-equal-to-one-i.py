class Solution:
    def minOperations(self, nums: List[int]) -> int:
        op = 0
        for i in range(2, len(nums)):
            if nums[i - 2] == 0:
                op += 1
                nums[i - 2] = 1 - nums[i - 2]
                nums[i - 1] = 1 - nums[i - 1]
                nums[i] = 1 - nums[i]
        if nums[-2] == 0 or nums[-1] == 0:
            return -1
        return op

        