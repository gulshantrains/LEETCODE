class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        count=Counter(nums)
        sorted_num=sorted(count.items(), key=lambda x:(x[1],-x[0]))
        
        ans=[]
        for num, val in sorted_num:
            ans.extend([num]*val)

        return ans
        