class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;

        for (var x : nums)
            if (check(x) % 2 == 0) cnt++;

        return cnt;
    }

    public int check(int n) {
        int d = 0;
        while (n > 0) {
            d++;
            n = n / 10;
        }
        return d;
    }
}