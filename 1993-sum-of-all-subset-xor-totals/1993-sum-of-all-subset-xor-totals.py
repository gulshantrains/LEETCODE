class Solution:
    def onway(self, nums: List[int], idx: int, curr: int) -> int:
        if idx == len(nums):
            return curr
        return self.onway(nums, idx + 1, curr ^ nums[idx]) + self.onway(nums, idx + 1, curr)

    def subsetXORSum(self, nums: List[int]) -> int:
        return self.onway(nums, 0, 0)
