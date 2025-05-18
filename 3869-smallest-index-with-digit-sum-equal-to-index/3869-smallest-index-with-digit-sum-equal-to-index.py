class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            d_sum=sum(int(x) for x in str(nums[i]))
            if d_sum==i:
                return i
        return -1
        