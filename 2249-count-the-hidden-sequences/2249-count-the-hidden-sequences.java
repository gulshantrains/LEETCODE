class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, min=0,max=0 ;   // prefix sum
            
        for (var x : differences) {
            sum += x;           // update sum
            min = Math.min(min, sum);    // update min
            max = Math.max(max, sum);   // update max
        }

        // total valid starting values
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
