class Solution {
    public int maxTotalFruits(int[][] A, int startPos, int k) {
        int left = 0, n = A.length, maxSum = 0, curSum = 0;

        for (int right = 0; right < n; ++right) {
            curSum += A[right][1];

            // (r-l) is Window Size (length of the fruit zone)
            // Math.min(Math.abs(startPos - l), Math.abs(startPos - r))  
            // This calculates the distance to the nearer of the two ends of the fruit zone. 
            // To be efficient, your first move should always be toward the closest entry point of the collection zone.
            while (left <= right && ((A[right][0] - A[left][0])
                    + Math.min(Math.abs(startPos - A[left][0]), Math.abs(startPos - A[right][0]))) > k) {
                curSum -= A[left][1];
                left++;
            }
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
