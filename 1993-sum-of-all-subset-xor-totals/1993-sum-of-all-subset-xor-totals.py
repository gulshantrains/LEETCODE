class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        subset=[]
        sum_ans=0

        for i in range(len(nums)+1):
            for x in itertools.combinations(nums,i):
                subset.append(list(x))

        for sub in subset:
            temp=sub
            sum_temp=0
            for x in temp:
                sum_temp ^=x

            sum_ans+=sum_temp

        return sum_ans

        