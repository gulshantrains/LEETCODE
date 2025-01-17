class Solution {
    public boolean doesValidArrayExist(int[] d) {
        return Arrays.stream(d).sum() % 2 == 0;
    }
}