class Solution {
    public double average(int[] s) {
        int n = s.length;
        double ans = 0;
        Arrays.sort(s);

        for (int x : s)
            ans += x;
        System.out.println(ans);
        ans = ans-(s[0] + s[n - 1]);
        System.out.println(ans);

        ans = (ans / (n - 2));
        System.out.println(ans);

        return ans;
    }
}