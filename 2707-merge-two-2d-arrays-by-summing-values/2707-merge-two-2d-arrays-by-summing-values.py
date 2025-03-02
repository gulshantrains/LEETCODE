class Solution:
    def mergeArrays(self, n1: List[List[int]], n2: List[List[int]]) -> List[List[int]]:
        ans=[]
        nl1,nl2,i,j=len(n1),len(n2),0,0

        while i<nl1 and j<nl2:
            if n1[i][0]==n2[j][0]:
                ans.append([n1[i][0],n1[i][1]+n2[j][1]])
                i +=1
                j +=1
            elif n1[i][0]<n2[j][0]:
                ans.append([n1[i][0],n1[i][1]])
                i +=1
            else:
                ans.append([n2[j][0],n2[j][1]])
                j +=1
        
        while i<nl1:
            ans.append(n1[i])
            i+=1
        while j<nl2:
            ans.append(n2[j])
            j+=1
        
        return ans
        