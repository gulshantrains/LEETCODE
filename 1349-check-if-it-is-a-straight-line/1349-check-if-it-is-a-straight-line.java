class Solution {
    public boolean checkStraightLine(int[][] c) {
        if (c.length == 2)
            return true;

        int dy = c[1][1] - c[0][1];
        int dx = c[1][0] - c[0][0];

        for (int i = 2; i < c.length; i++) {
            if (((c[i][1] - c[i - 1][1]) * dx) != ((c[i][0] - c[i - 1][0]) * dy))
                return false;
        }
        return true;
    }
}