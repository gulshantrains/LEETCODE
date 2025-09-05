class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) { // at most 60 since 2^60 is huge
            long diff = (long) num1 - (long) k * num2;
            if (diff < k) continue; // need at least k ones
            if (Long.bitCount(diff) <= k && k <= diff) {
                return k;
            }
        }
        return -1;
    }
}
