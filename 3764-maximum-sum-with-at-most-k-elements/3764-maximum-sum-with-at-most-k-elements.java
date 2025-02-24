class Solution {
    public long maxSum(int[][] grid, int[] li, int k) {
        int n = grid.length;
        int m = grid[0].length;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] row : grid) {
            Arrays.sort(row); // Sort in ascending order
            reverse(row); // Reverse to get descending order
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.min(li[i], m); j++) {
                pq.offer(grid[i][j]);

                if (pq.size() > k)
                    pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }

    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
// The task is to find the maximum sum of at most k elements from the matrix
// such that:
// ->The number of elements taken from the i'th row of grid does not exceed
// limits[i]..
// ....limit.length==grid.length(grid rows) && limit[i]<=element from ROW 'i'