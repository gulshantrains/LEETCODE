class Solution {
    public int earliestTime(int[][] tasks) {
        int res = 100_000_000;

        for (int[] cod : tasks) {
            if (cod[0] + cod[1] < res)
                res = cod[0] + cod[1];
        }

        return res;
    }
}