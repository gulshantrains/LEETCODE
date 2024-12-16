class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        for _ in range(k):
            min_idx=0
            for j in range(len(nums)):
                if nums[j] < nums[min_idx] :
                    min_idx=j

            nums[min_idx] *=multiplier

        return nums

        