class Solution {
    public int candy(int[] R) {
        int n = R.length;
        int sum = n;

        int i = 1;
        while (i < n) {
            if (R[i] == R[i - 1]) {
                i++;
                continue; //Platue No change
            }

            int peak = 0; //We are on going on upward or peak
            while (R[i] > R[i - 1]) {
                peak++;
                sum += peak;
                i++;
                if (i == n)
                    return sum;
            }

            int dip = 0;
            while (i < n && R[i] < R[i - 1]) {
                dip++;
                sum += dip;
                i++;
            }
            sum -= Math.min(peak, dip);
        }
        return sum;
    }
}
// Adjust for the peak:
// The peak child (which was R[i-1] before the downhill loop, or earlier if peak > 0 and dip == 0)
// was counted in both uphill and downhill sums of additional candies.
// It needs max(peak_length, dip_length) additional candies.
// We added peak_length + dip_length. So subtract min(peak_length, dip_length).
// This only applies if there was an actual peak (both peak > 0 and dip > 0).
// If peak = 0 (started with downhill/plateau) or dip = 0 (ended with uphill/plateau), min is 0.