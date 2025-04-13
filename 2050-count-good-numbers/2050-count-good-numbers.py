class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD=10**9+7
        ev,od=(n+1)//2,n//2

        return (pow(5,ev,MOD)*pow(4,od,MOD))%MOD
        