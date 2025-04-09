class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        unique=set()

        for i in range(len(nums)):
            if nums[i] < k:
                return -1
            unique.add(nums[i])

        return len(unique)-1 if k in unique else len(unique) 

        

        