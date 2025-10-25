class Solution {
    public int totalMoney(int n) {
        int full_week = n / 7;
        int rem_days = n % 7;
        
        return ((7 * full_week * full_week + 49 * full_week) + (rem_days * (2 * full_week + rem_days + 1))) >> 1;
    }
}