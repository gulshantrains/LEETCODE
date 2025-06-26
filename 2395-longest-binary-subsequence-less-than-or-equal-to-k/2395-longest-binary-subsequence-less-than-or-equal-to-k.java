class Solution {
    public int longestSubsequence(String s, int k) {
        // 'ans' is the length of our subsequence.
        int ans = 0;
        // 'val' is the numerical value of the subsequence. Use long to prevent overflow with k.
        long val = 0;
        // 'pwr' is the value of the current bit position (2^0, 2^1, 2^2, ...).
        long pwr = 1;

        // Iterate from right to left (LSB to MSB)
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);

            if (temp == '0') {
                // Zeroes always increase length and are always "affordable".
                ans++;
            } else { // temp == '1'
                // Check if we can afford to include this '1' at its current bit position.
                if (val + pwr <= k) {
                    val += pwr;
                    ans++;
                }
            }

            // The power of 2 increases for the next position to the left,
            // regardless of whether we took the current character or not.
            // We can add a check to stop pwr from growing unnecessarily large and overflowing.
            if (pwr <= k) { // k is an upper bound on any useful power of 2
                pwr *= 2;
            }
        }

        return ans;
    }
}