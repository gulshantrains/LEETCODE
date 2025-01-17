class Solution:
    def doesValidArrayExist(self, d: List[int]) -> bool:
        return sum(d) % 2 == 0
