class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        max_rank=max(ranks)
        l,r,ans=1,max_rank*cars*cars,0

        while(l<=r):
            mid=l+(r-l)//2

            total = sum(int(sqrt(mid // num)) for num in ranks)

            if(total>=cars):
                ans=mid
                r=mid-1
            else:
                l=mid+1

        return ans
        