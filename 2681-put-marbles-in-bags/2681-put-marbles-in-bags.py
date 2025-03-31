class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        n,pair_sum=len(weights),[]
        if k == 1:
            return 0
            
        for i in range(1,n):
            pair_sum.append(weights[i-1]+weights[i])

        pair_sum.sort()

        return sum(pair_sum[-(k-1):])-sum(pair_sum[:(k-1)])


        