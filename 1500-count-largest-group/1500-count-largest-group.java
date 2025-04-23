class Solution {
    public int countLargestGroup(int n) {
        int[] ds = new int[37];
        for (int i = 1; i <= n; i++) {
            ds[sum(i)]++;
        }
        int cnt = 1, maxval = 0;

        for (int i = 0; i < 37; i++) {
            if (ds[i] > maxval) {
                cnt=1;;
                maxval = ds[i];
            } else if (ds[i] == maxval){
                cnt++;
            }
        }
        return cnt;
    }

    public int sum(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
