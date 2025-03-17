class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(1,len(nums),2):
            if nums[i-1] != nums[i]:
                return False
        return True
        