class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] ar = new int[101];
        int pop = 0;
        int maxPop = 0;
        int maxY = 0;

        for (var x : logs) {
            int b = x[0];
            int d = x[1];

            ar[b - 1950]++;
            ar[d - 1950]--;
        }
        int runpop = 0;
        for (int i = 0; i < 101; i++) {
            runpop += ar[i]; //At any time people alive in that particular year

            if (runpop > maxPop) { //If curr exceed max pop then updat maxpop
                maxPop = runpop;
                maxY = i + 1950; //now it means that max year will change
            }
        }
        return maxY;
    }
}