class Solution {
    public boolean doesValidArrayExist(int[] d) {
        int res = 0;
        for (int x : d) {
            res ^= x;
        }
        return res == 0;
    }
}