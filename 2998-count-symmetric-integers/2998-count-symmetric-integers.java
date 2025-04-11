class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        // Process 2-digit symmetric numbers
        // They have one digit in each half, and symmetry forces them to be the same.
        for (int d = 1; d <= 9; d++) {
            int num = d * 10 + d;  // Forms 11, 22, ... 99.
            if (num >= low && num <= high) {
                count++;
            }
        }
        
        // Process 4-digit symmetric numbers.
        // The first half must be a 2-digit number (from 10 to 99).
        // The second half is from 0 to 99 (leading zero allowed).
        // They form the full number as: first * 100 + second.
        for (int first = 10; first <= 99; first++) {
            int sumFirst = sumDigits(first);
            for (int second = 0; second <= 99; second++) {
                if (sumDigits(second) == sumFirst) {
                    int num = first * 100 + second;
                    if (num >= low && num <= high) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    // Helper to compute the sum of digits of an integer.
    private int sumDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
