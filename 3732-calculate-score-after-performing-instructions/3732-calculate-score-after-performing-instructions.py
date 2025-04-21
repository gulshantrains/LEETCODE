class Solution:
    def calculateScore(self, ins: List[str], values: List[int]) -> int:
        i, ans = 0, 0
        n = len(ins)
        visited = set()

        while 0 <= i < n:
            if i in visited:
                break

            visited.add(i)

            if ins[i] == "jump":
                i = i + values[i]
            else:
                ans += values[i]
                i += 1

        return ans
