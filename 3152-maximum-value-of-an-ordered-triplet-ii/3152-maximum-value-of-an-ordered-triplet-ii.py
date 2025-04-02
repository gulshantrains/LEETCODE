class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        res=0
        pre_max=nums[0]
        max_diff=0

        for i in range(1,len(nums)):
            res=max(res,max_diff*nums[i])
            pre_max=max(pre_max,nums[i])
            max_diff=max(max_diff,pre_max-nums[i])

        return res
         
        