class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        map={0:-1}
        sum=0

        for i in range(len(nums)):
            sum +=nums[i]
            val=sum%k

            if val in map:
                idx=map[val]

                if i-idx>1:
                    return True
            else:
                map[val]=i

        return False
        