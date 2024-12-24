class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        freq_map = {}
        
        for x in nums:
            freq_map[x] = freq_map.get(x, 0) + 1

        for key, value in freq_map.items():
            if value == 1:
                return key

        return -1
