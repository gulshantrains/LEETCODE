class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        ans=[]

        for num in nums:
            if num<pivot:
                ans.append(num)
        for num in nums:
            if num==pivot:
                ans.append(num)
        for num in nums:
            if num>pivot:
                ans.append(num)

        return ans
        