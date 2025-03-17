class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        count=Counter(nums)
        #print(count)
        for i in count.values():
            if i%2 != 0:
                return False
        return True
        