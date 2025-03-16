class Solution:
    def can(self, ranks: List[int], time: int, cars: int) -> bool:
        total = 0
        for x in ranks:
            total += int(sqrt(time // x))

        return total >= cars

    def repairCars(self, ranks: List[int], cars: int) -> int:
        l, r, ans = 1, max(ranks) * cars * cars, 0

        while l <= r:
            mid = (l + r) // 2

            if self.can(ranks, mid, cars):
                ans = mid
                r = mid - 1
            else:
                l = mid + 1

        return ans
