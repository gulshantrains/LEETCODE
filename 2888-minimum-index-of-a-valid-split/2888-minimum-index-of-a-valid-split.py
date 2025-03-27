class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        # Step 1: Boyer–Moore to find dominant candidate
        dom_ele = nums[0]
        counter = 1

        for i in range(1, len(nums)):
            if counter == 0:
                dom_ele = nums[i]
                counter = 1
            elif nums[i] == dom_ele:
                counter += 1
            else:
                counter -= 1 

        # Step 2: Confirm if it's actually dominant
        temp_cnt = nums.count(dom_ele)
        if temp_cnt * 2 <= len(nums):  # Must be strictly > n/2
            return -1

        # Step 3: Check valid split point
        c = 0  # Count of dom_ele in prefix
        for i in range(len(nums) - 1):
            if nums[i] == dom_ele:
                c += 1
            if (c > (i + 1) // 2 and (temp_cnt - c) > (len(nums) - i - 1) // 2):
                return i

        return -1
