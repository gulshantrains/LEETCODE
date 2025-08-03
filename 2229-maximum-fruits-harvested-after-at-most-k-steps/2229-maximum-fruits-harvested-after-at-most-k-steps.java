class Solution {
    public int maxTotalFruits(int[][] A, int startPos, int k) {
        int left = 0, n = A.length, maxSum = 0, curSum = 0;

        for (int right = 0; right < n; ++right) {
            curSum += A[right][1];

            int l = A[left][0];
            int r = A[right][0];

            /*
             (r-l) is Window Size(length of the fruit zone)
              Math.min(Math.abs(startPos - l), Math.abs(startPos - r)  
              This calculates the distance to the nearer of the two ends of the fruit zone. 
              To be efficient, your first move should always be toward the closest entry point of the collection zone.
            */
            int cost = (r - l) + Math.min(Math.abs(startPos - l), Math.abs(startPos - r));

            while (left <= right && cost > k) {
                curSum -= A[left][1];
                left++;
                
                if (left <= right)
                    l = A[left][0];
                cost = (r - l) + Math.min(Math.abs(startPos - l), Math.abs(startPos - r));
            }
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}