/*--2D array grid of size 2 x n...
--grid[r][c] represents the number of points at position (r, c) on the matrix
--Each robot may only move to the right ((r, c) to (r, c + 1)) or
 down ((r, c) to (r + 1, c))...
--The first robot moves from (0, 0) to (1, n-1), collecting all the points from     cells on its path.
--For all cells (r, c) traversed on the path, grid[r][c] is set to 0.
--The second robot moves from (0, 0) to (1, n-1), collecting the points in path
 (0, 0) to (1, n-1)....their paths may intersect with one another.
--The first robot wants to minimize the number of points collected by the second robot
--second robot wants to maximize the number of points it collects

------>return the number of points collected by the second robot.
*/
class Solution {

    public long gridGame(int[][] grid) {
        // Calculate the sum of all the elements for the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;
        for (int turnIndex = 0; turnIndex < grid[0].length; ++turnIndex) {
            firstRowSum -= grid[0][turnIndex];
            // Find the minimum maximum value out of firstRowSum and
            // secondRowSum.
            minimumSum = Math.min(
                    minimumSum,
                    Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][turnIndex];
        }
        return minimumSum;
    }
}