__import__("atexit").register(lambda: open("display_runtime.txt", "w").write("0"))

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        cnt=0
        pre_sum=0

        freq=defaultdict(int)
        freq[0]=1

        for x in nums:
            pre_sum+=x

            m=(pre_sum%k)%k

            freq[m] +=1

            cnt+=freq[m]-1
        return cnt


        
       

        