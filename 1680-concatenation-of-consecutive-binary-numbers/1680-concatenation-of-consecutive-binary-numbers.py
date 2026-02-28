class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = 10**9 + 7
        ls1 = []

        for i in range(1, n + 1):
            ls1.append(bin(i)[2:])

        return int("".join(ls1), 2) % mod


"""
class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = int(10e9 + 7)
        ls1 = []

        for i in range(1, n + 1):
            ls1.append(bin(i)[2:])

        return int("".join(ls1), 2) % mod

"""
