class Solution {
    public int trap(int[] h) {

        int rain = 0, lmax = 0, rmax = 0, l = 0, r = h.length - 1;

        while (l <= r) {
            if (h[l] > h[r]) {
                rmax = Math.max(rmax, h[r]); //Minimum will be used to store

                rain += rmax - h[r];
                r--;
            } else {
                lmax = Math.max(lmax, h[l]);

                rain += lmax - h[l];
                l++;
            }
        }
        return rain;
    }
}
/*
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmh = new int[n];
        int[] rmh = new int[n];

        lm(height, lmh);
        rm(height, rmh);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.min(lmh[i], rmh[i]) - height[i];
        }
        return sum;
    }

    public void lm(int[] h, int[] lmh) {
        lmh[0] = h[0];

        for (int i = 1; i < h.length; i++) {
            lmh[i] = Math.max(lmh[i - 1], h[i]);
        }
    }

    public void rm(int[] h, int[] rmh) {
        rmh[h.length - 1] = h[h.length - 1];

        for (int i = h.length - 2; i >= 0; i--) {
            rmh[i] = Math.max(rmh[i + 1], h[i]);
        }
    }
}
*/
