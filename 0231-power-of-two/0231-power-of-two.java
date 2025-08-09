class Solution {
    public boolean isPowerOfTwo(int n) {
       // System.out.println(Integer.bitCount(31));
        if (n <= 0)
            return false;
        return ((n & n - 1) == 0);
    }
}