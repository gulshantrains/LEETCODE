class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] ar = new int[101];
        int pop = 0, maxPop=0, maxY=1950;
       
        for (var x : logs) {
            ar[x[0] - 1950]++;
            ar[x[1] - 1950]--;
        }

        int runpop = 0;
        for (int i = 0; i < 101; i++) {
            runpop += ar[i]; // At any time people alive in that particular year

            if (runpop > maxPop) { // If curr exceed max pop then updat maxpop
                maxPop = runpop;
                maxY = i + 1950; // now it means that max year will change
            }
        }
        return maxY;
    }
}