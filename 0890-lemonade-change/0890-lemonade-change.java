class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt10 = 0, cnt5 = 0;

        for (int x : bills) {
            if (x == 5) {
                cnt5++;
            } else if (x == 10) {
                if (cnt5 == 0)
                    return false;
                if (cnt5 > 0)
                    cnt5--;
                cnt10++;
            } else {
                if (cnt10 > 0 && cnt5 > 0) {
                    cnt5--;
                    cnt10--;
                } else if (cnt5 > 2)
                    cnt5 -= 3;
                else
                    return false;
            }
        }
        return true;

    }
}