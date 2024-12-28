class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        l,r=0,len(arr)-1

        while(l<=r):
            mid=(l+r)//2

            if(arr[mid]-(mid+1) >= k): #missing No:what should has been at that place if
                r=mid-1                #if that no has been present
            else:
                l=mid+1

        return r+k+1
        