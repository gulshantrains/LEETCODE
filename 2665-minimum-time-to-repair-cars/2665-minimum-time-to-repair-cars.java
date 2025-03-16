class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long maxrank = Arrays.stream(ranks).max().getAsInt();
        long l = 1, r = maxrank * cars * cars;
        long ans = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (isPossible(mid, ranks, cars)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
    public boolean isPossible(long time, int[] ranks, int cars){
        int total=0;

        for(int x: ranks){
            total +=Math.sqrt(time/x);
        }
        return total>=cars;
    }
}
// ..-> A mechanic with a rank 'r' can repair 'n' cars in 'r * n2' minutes.
// ..->:: Return the minimum time taken to repair all the cars.
// ... Note: All the mechanics can repair the cars simultaneously.