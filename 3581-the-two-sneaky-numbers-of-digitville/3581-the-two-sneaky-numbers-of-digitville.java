class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // 1. Find n
        int n = nums.length - 2;
        
        // 2. Calculate expected sums (for 0 to n-1)
        // We use long to prevent potential overflow during calculations
        long expectedSum = (long)n * (n - 1) / 2;
        long expectedSumSq = (long)(n - 1) * n * (2 * n - 1) / 6;
        
        // 3. Calculate actual sums
        long actualSum = 0;
        long actualSumSq = 0;
        
        for (int x : nums) {
            actualSum += x;
            actualSumSq += (long)x * x;
        }
        
        // 4. Find S1 (a + b) and S2 (a^2 + b^2)
        long S1 = actualSum - expectedSum;
        // S2 is the sum of the squares of the two duplicates
        long S2 = actualSumSq - expectedSumSq;
        
        // 5. Find D (a - b)
        // D_sq = (a - b)^2 = 2*S2 - S1^2
        long D_sq = 2 * S2 - S1 * S1;
        int D = (int)Math.sqrt(D_sq);
        
        // 6. Solve for a and b
        // a + b = S1
        // a - b = D
        // Adding them: 2a = S1 + D  => a = (S1 + D) / 2
        // Subbing them: 2b = S1 - D  => b = (S1 - D) / 2
        int a = (int)(S1 + D) / 2;
        int b = (int)(S1 - D) / 2;
        
        return new int[]{a, b};
    }
}