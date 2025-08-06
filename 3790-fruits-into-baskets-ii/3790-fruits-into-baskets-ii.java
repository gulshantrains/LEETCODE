class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length, ans = 0;

        for (int fr : f) {
            boolean flag = true;

            for (int i = 0; i < b.length; i++) {
                if (b[i] >= fr) {
                    b[i] = -1;
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }
        return ans;

    }
}