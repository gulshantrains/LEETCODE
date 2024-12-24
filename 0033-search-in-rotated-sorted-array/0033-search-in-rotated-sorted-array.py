class Solution:
    def search(self, nums: List[int], target: int) -> int:
        idx = self.find_pivot(nums)
        lidx = self.binary_search(nums, 0, idx - 1, target)
        ridx = self.binary_search(nums, idx, len(nums) - 1, target)

        if lidx == -1 and ridx == -1:
            return -1

        return max(lidx, ridx)

    def binary_search(self, nums: List[int], left: int, right: int, target: int) -> int:
        l, r = left, right

        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1

        return -1

    def find_pivot(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        return r