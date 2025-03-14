class Solution:
    def maximumCandies(self, candy: List[int], k: int) -> int:
        total_sum=sum(candy)

        if(total_sum<k):
            return 0
        l,r=1,total_sum//k
        ans=0

        while(l<=r):
            mid=(r+l)//2

            children=sum(pile//mid for pile in candy)

            if(children>=k):
                ans=mid
                l=mid+1
            else:
                r=mid-1
        return ans*1

            
        