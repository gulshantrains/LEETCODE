class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        #InBuilt PreSum function with first value 0 
        pre = list(accumulate(differences, initial=0)) 

        return max(0, (upper - lower) - (max(pre) - min(pre)) + 1)

        