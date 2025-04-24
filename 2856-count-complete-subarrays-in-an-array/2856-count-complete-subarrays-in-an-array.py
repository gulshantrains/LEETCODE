class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        d=len(set(nums))
        n=len(nums)

        freq=defaultdict(int)
        i=j=ans=0

        while(i<n):
            freq[nums[i]] +=1

            while len(freq)==d:
                ans +=(n-i)

                freq[nums[j]] -=1
                if(freq[nums[j]]==0):
                    del freq[nums[j]]
                j+=1
            i +=1
        return ans


        