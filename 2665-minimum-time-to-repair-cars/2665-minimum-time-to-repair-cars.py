class Solution:
    def canRepair(self, ranks, val, cars):
        repaired = 0
        for rank in ranks:
            car = int(math.sqrt(val//rank))
            repaired+=car 
        if val==16:
            print(repaired)
        return repaired>=cars
    def repairCars(self, ranks: List[int], cars: int) -> int:
        mintime, maxtime = 0, max(ranks)*cars*cars
        final = 0
        while mintime<=maxtime:
            mid = (mintime+maxtime)//2
            if self.canRepair(ranks, mid, cars):
                final = mid
                maxtime = mid-1
            else:
                mintime = mid+1
        return final
        
        