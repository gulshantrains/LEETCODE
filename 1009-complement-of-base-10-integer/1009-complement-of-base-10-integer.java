class Solution {
    public int bitwiseComplement(int n) {
        int len = Integer.toBinaryString(n).length();

        int num = (int)Math.pow(2, len) - 1;

        return n ^ num;

    }
}