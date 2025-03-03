class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        less=[]
        more=[]
        eq=[]

        for x in nums:
            if x<pivot:
                less.append(x)
            elif x>pivot:
                more.append(x)
            else:
                eq.append(x)
            
        less.extend(eq)
        less.extend(more)

        return less
        