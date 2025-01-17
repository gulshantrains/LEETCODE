class Solution {
    public boolean doesValidArrayExist(int[] d) {
        int res = 0;
        for (var x : d) {
            res ^= x;
        }
        return res == 0;
    }
}