class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            int t = count(i);

            if (t % 2 != 0)
                continue;

            int n = t / 2;
            int num = i;

            int fh = 0, sh = 0;
            for (int j = 0; j < n; j++) {
                sh += num % 10;
                num /= 10;
            }
            for (int j = 0; j < n; j++) {
                fh += num % 10;
                num /= 10;
            }
            if (fh == sh)
                ans++;
        }
        return ans;
    }

    public int count(int nums) {
        int cnt = 0;

        while (nums > 0) {
            int rem = nums % 10;
            nums /= 10;
            cnt++;
        }
        return cnt;
    }
}