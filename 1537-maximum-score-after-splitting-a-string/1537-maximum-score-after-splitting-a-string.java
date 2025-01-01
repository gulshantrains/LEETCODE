class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ans = 0;
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            int lcnt = 0, rcnt = 0;
            StringBuilder right = new StringBuilder();
            left.append(s.substring(i, i + 1));
            right.append(s.substring(i + 1, n));

            System.out.println(left);
            System.out.println(right);

            for (int j = 0; j < left.length(); j++) {
                if (left.charAt(j) == '0')
                    lcnt++;
            }
            System.out.println(lcnt);
            for (int k = 0; k < right.length(); k++) {
                if (right.charAt(k) == '1')
                    rcnt++;
            }
            System.out.println(rcnt);
            ans = Math.max(ans, (lcnt + rcnt));

        }
        return ans;
    }
}