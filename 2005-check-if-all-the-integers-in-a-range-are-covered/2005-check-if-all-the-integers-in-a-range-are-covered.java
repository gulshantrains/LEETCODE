class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] ar = new int[51];

        for (var x : ranges) {
            for (int i = x[0]; i <= x[1]; i++) {
                ar[i] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (ar[i] != 1)
                return false;
        }
        return true;
    }
}