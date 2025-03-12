class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        zero,pos=0,0
        
        for num in nums:
            if num==0:
                zero +=1
            elif num>0:
                pos +=1
        return max(pos,len(nums)-zero-pos)