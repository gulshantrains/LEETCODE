class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        frq = {}  # Take map
        good_pair = 0  # For good pair
        n = len(nums)  # Size of Array

        for i, num in enumerate(nums):
            val = num - i
            good_pair += frq.get(val, 0)  # If we have seen earlier then form good pair

            frq[val] = frq.get(val, 0) + 1  # Update good pair

        return n * (n - 1) // 2 - good_pair
