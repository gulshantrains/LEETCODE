class Solution:
    def returnToBoundaryCount(self, nums: List[int]) -> int:
        ans=temp=0
        
        for x in nums:
            temp +=x
            if temp==0:
                ans+=1
        return ans

        