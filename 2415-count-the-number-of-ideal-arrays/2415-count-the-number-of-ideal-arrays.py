MOD = 10**9 + 7

class Combinations:
    def __init__(self, n, mod):
        self.M = mod
        self.fact = [1] * (n + 1)
        self.inv_fact = [1] * (n + 1)

        for i in range(1, n + 1):
            self.fact[i] = self.fact[i - 1] * i % mod
            self.inv_fact[i] = pow(self.fact[i], mod - 2, mod)

    def nCr(self, n, r):
        if r < 0 or r > n:
            return 0
        return self.fact[n] * self.inv_fact[r] % self.M * self.inv_fact[n - r] % self.M

class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        comb = Combinations(n, MOD)
        dp = [1] * (maxValue + 1)
        total = sum(dp[1:]) % MOD  # Base case: k=1

        kLimit = min(n, 16)
        for k in range(2, kLimit + 1):
            next_dp = [0] * (maxValue + 1)
            for j in range(1, maxValue + 1):
                if dp[j] == 0:
                    continue
                for i in range(2 * j, maxValue + 1, j):
                    next_dp[i] = (next_dp[i] + dp[j]) % MOD

            count = sum(next_dp[1:]) % MOD
            if count == 0:
                break

            factor = comb.nCr(n - 1, k - 1)
            total = (total + count * factor % MOD) % MOD
            dp = next_dp

        return total
