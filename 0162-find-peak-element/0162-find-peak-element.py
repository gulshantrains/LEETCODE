class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            mid = l + (r - l) // 2

            # If the middle element is smaller than the next element, the peak must be to the right
            if nums[mid] < nums[mid + 1]:
                l = mid + 1
            else:  # Otherwise, the peak must be to the left or at mid
                r = mid

        return l
