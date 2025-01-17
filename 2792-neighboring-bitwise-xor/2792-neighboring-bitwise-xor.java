class Solution {
    public boolean doesValidArrayExist(int[] d) {
        int zero_count = 0, one_count = 0;

        for (int i = 0; i < d.length; i++) {
            if (d[i] == 1) {
                zero_count += 1;
                one_count += 1;
            } else {
                one_count += 2;
            }
        }
        if (zero_count % 2 == 0 && one_count % 2 == 0)
            return true;

        return false;
    }
}