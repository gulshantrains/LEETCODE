class Solution {
    public int numWaterBottles(int nB, int nE) {
        int ans = nB;
        while (nB != 0) {
            int water = nB / nE;
            int empty = nB % nE;

            ans += water;
            nB = water + empty;

            if (nB < nE)
                break;
        }
        return ans;
    }
}