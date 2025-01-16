class Solution {
    public int xorAllNums(int[] A, int[] B) {
        int xorA = 0, xorB = 0, result = 0;

        for (int x : A)
            xorA ^= x;
        for (int x : B)
            xorB ^= x;

        if (A.length % 2 == 1)
            result ^= xorB;

        if (B.length % 2 == 1)
            result ^= xorA;

        return result;
    }
}