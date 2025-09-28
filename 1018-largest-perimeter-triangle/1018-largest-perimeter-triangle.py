class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        n,ans=len(nums),0
        

        for i in range(n-3,-1,-1):
            a,b,c=nums[i],nums[i+1],nums[i+2]
            
            if a+b>c and b+c>a and a+c>b:
                ans=max(ans,a+b+c)
                
        
        return ans
        