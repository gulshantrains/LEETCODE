class Solution:
    def maxScore(self, s: str) -> int:
        ones=s.count("1")
        zero,ans=0,0
        
        for i in range(len(s)-1):
            if(s[i]=="1"):
                ones -=1
            else:
                zero+=1
            ans=max(ans,ones+zero)

        return ans
        