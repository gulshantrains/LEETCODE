class Solution {
    public long countDistinct(long n) {
        String s = Long.toString(n);
        int len = s.length();
        long ans = 0;
        
        // ---------------------------------------------------------
        // Part 1: Count valid numbers with fewer digits than n
        // ---------------------------------------------------------
        // A number of length L with no zeros has 9^L possibilities.
        // We sum 9^1 + 9^2 + ... + 9^(len-1).
        
        long powerOf9 = 1; 
        for (int i = 1; i < len; i++) {
            powerOf9 *= 9;
            ans += powerOf9;
        }
        
        // At this point, powerOf9 equals 9^(len-1). 
        // This represents the combinations for the remaining positions
        // when we process the first digit of n.

        // ---------------------------------------------------------
        // Part 2: Count valid numbers with the same length as n
        // ---------------------------------------------------------
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            
            // Try placing a digit strictly smaller than the current 'digit'.
            // The valid candidates are 1, 2, ..., digit-1.
            // So there are (digit - 1) choices.
            // Note: If digit is 0, (digit-1) is negative, handled by check below.
            if (digit > 0) {
                ans += (long) (digit - 1) * powerOf9;
            }
            
            // If the current digit of n is '0', we cannot match this prefix
            // because valid numbers cannot contain zeros. We stop counting.
            if (digit == 0) {
                return ans;
            }
            
            // Prepare powerOf9 for the next iteration (move one position to the right)
            // Example: 9^2 -> 9^1 -> 9^0
            if (i < len - 1) {
                powerOf9 /= 9;
            }
        }
        
        // If we finish the loop, it means n itself contains no zeros.
        // We must count n itself.
        ans++;
        
        return ans;
    }
}