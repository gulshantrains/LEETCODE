class Solution {
    public int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; //Total Rows
        int n = grid[0].length; //Total column

        if (m == 0 || n == 0 || grid[0][0] != 0) //May be we have starting cell as 1 so return -1
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;

        int level = 0;

        while (!q.isEmpty()) {
            int N = q.size();

            for (int i = 0; i < N; i++) {

                int[] temp = q.poll();
                int x = temp[0], y = temp[1];

                if (x == m - 1 && y == n - 1)
                    return level + 1;

                for (var d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];

                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 1)
                        continue;

                    q.offer(new int[] { newX, newY });
                    grid[newX][newY] = 1;
                }

            }
            level++;
        }
        return -1;
    }
}