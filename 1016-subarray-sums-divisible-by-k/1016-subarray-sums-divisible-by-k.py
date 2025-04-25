class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        cnt=0
        pre_sum=list(itertools.accumulate(nums))

        freq=defaultdict(int)
        freq[0]=1

        for x in pre_sum:
            m=(x%k)%k
            freq[m] +=1

            cnt+=freq[m]-1
        return cnt


        
       

        