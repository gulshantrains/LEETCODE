class Solution {
    public int xorAllNums(int[] A, int[] B) {
        int xorA = 0, xorB = 0, result = 0;
    //XOR is associaive in nature (a ^ b=b^a)
    //XOR is commututative in nature (a^b))^c=a^(b^c)


        for (int x : A)
            xorA ^= x; //Take xor of A
        for (int x : B)
            xorB ^= x; //take xor of B

        if (A.length % 2 == 1)
            result ^= xorB; //If a length is odd then B will contribute otherwsise not

        if (B.length % 2 == 1)
            result ^= xorA; //if B length is odd then it will conntribute 

        return result;
    }
}