class Solution {
    public int mySqrt(int x) {
        int ans = 0, left = 1, right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid > x)
                right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}