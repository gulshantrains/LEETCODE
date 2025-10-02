class Solution {
    public int maxBottlesDrunk(int nB, int nE) {
        int ans = 0;

        while (nB >= nE) {
            ans += nE;
            nB = nB - nE + 1;
            nE++;
        }
        return ans + nB;
    }
}