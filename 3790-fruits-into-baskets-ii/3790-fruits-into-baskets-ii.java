class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int count = 0;

        for (int i = 0; i < f.length; i++) {
            boolean flag = true;

            for (int j = 0; j < b.length; j++) {
                if (b[j] == -1) // This basket is already full
                    continue;
                else if (b[j] >= f[i]) {
                    flag = false;
                    b[j] = -1; // Fill this basket
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }
}