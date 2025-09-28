class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        n=len(nums)
        nums.sort()
        
        for i in range(n-3,-1,-1):
            a,b,c=nums[i],nums[i+1],nums[i+2]
            
            if a+b>c and b+c>a and a+c>b:
                return a+b+c
        
        return 0
        