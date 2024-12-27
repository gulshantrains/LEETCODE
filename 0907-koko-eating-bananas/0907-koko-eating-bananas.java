class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int l = 1, r = piles[n - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int hr = 0;

            for (int i = 0; i < n; i++) {
                hr += (int) Math.ceil((double) piles[i] / mid);
            }
            if (hr <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }
}