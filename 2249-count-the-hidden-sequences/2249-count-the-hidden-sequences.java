class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        long pre = 0,           // running sum of differences
                minPre = 0,     // min prefix sum seen
                maxPre = 0;     // max prefix sum seen

        for (int d : diff) {
            pre += d;                   // extend prefix by current difference
            minPre = Math.min(minPre, pre);
            maxPre = Math.max(maxPre, pre);
        }

        long low = lower - minPre;
        long high = upper - maxPre;

        // number of integer values in [low, high], or 0 if empty
        return (int) Math.max(0, high - low + 1);
    }
}
