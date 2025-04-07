class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        t_sum=sum(nums)

        if(t_sum%2 != 0):
            return False
        
        target=t_sum//2

        dp=[False]*(target+1)

        dp[0]=True

        for num in nums:
            for i in range(target,num-1,-1):
                dp[i]=dp[i] or dp[i-num]
                
        return dp[target]