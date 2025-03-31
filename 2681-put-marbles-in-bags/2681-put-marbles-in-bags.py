class Solution:
    def putMarbles(self, w: List[int], k: int) -> int:
        if k == 1: #If partition is 1 then sum diff will always 0
            return 0

        pair_sum=[w[i]+w[i+1] for i in range(len(w)-1)] #Store pair wise sum

        pair_sum.sort() #Sort to get mini & max easily

        return sum(pair_sum[-(k-1):])-sum(pair_sum[:(k-1)]) #Use negative indexing


        