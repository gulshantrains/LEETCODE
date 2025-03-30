class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n,l=len(s),0
        ans=[]*n

        while(l<n):
            r=s.rfind(s[l]) #Last Character
            i=l

            while(i<r):
                r=max(r,s.rfind(s[i]))
                i+=1
            ans.append(r-l+1)
            l=r+1
            
        return ans


        