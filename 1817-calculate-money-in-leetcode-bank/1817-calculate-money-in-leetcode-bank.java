class Solution {
    public int totalMoney(int n) {
        int di = n / 7;
        int re = n % 7;

        return ((7 * di * di + 49 * di) + (re * (2 * di + re + 1))) >> 1;
    }
}