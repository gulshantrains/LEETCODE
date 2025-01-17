class Solution:
    def doesValidArrayExist(self, d: List[int]) -> bool:
        res = 0
        for i in d:
            res = res ^ i
        return res == 0
